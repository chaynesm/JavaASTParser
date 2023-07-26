package edu.isnap.javaparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.isnap.javaparser.PrettyPrint.Params;

public class ASTNode {
	public final String type;
	public final String value;
	public final ArrayList<ASTNode> children;
	public final int[] sourceStart;
	public final int[] sourceEnd;

	public ASTNode parent;

	public ASTNode(String type, String value, ArrayList<ASTNode> children, int[] sourceStart, int[] sourceEnd) {
		super();
		this.type = type;
		this.value = value;
		this.children = children;
		this.sourceStart = sourceStart;
		this.sourceEnd = sourceEnd;
		this.children.forEach(c -> c.parent = this);
	}

	public ASTNode getParent() {
		return parent;
	}

	public String getType() {
		return type;
	}
//	public void setType(String type) {
//		this.type = type;
//	}
	public String getValue() {
		return value;
	}
//	public void setValue(String value) {
//		this.value = value;
//	}
	public ArrayList<ASTNode> getChildren() {
		return children;
	}
//	public void setChildren(ArrayList<ParsedNode> children) {
//		this.children = children;
//	}
	public int[] getSourceStart() {
		return sourceStart;
	}
//	public void setSourceStart(int[] sourceStart) {
//		this.sourceStart = sourceStart;
//	}
	public int[] getSourceEnd() {
		return sourceEnd;
	}
//	public void setSourceEnd(int[] sourceEnd) {
//		this.sourceEnd = sourceEnd;
//	}

	public int index() {
		return this.parent.children.indexOf(this);
	}

	static PrettyPrint.Params params = new Params();
	static {
		params.isBodyType = (type) -> {
			String[] variableChildrenTypes = {"Modifier", "Operator", "NameExpr",
					"Parameter", "IntegerLiteralExpr", "VoidType", "PrimitiveType"};
			return !Arrays.asList(variableChildrenTypes).contains(type);
		};
	}

	@Override
	public String toString() {
//		return "ParsedNode [type=" + type + ", value=" + value + ", children=" + children + ", sourceStart="
//				+ Arrays.toString(sourceStart) + ", sourceEnd=" + Arrays.toString(sourceEnd) + "]";
		return PrettyPrint.toString(this, params);
	}

	public boolean hasAncestor(Predicate pred) {
		return pred.eval(this) || hasProperAncestor(pred);
	}

	public boolean hasProperAncestor(Predicate pred) {
		return parent != null && parent.hasAncestor(pred);
	}

	public boolean exists(Predicate pred) {
		return search(pred) != null;
	}

	public ASTNode search(Predicate pred) {
		if (pred.eval(this)) return this;
		for (ASTNode node : children) {
			ASTNode found = node.search(pred);
			if (found != null) return found;
		}
		return null;
	}

	public List<ASTNode> allChildren() {
		return allChildren(new LinkedList<ASTNode>());
	}

	public List<ASTNode> allChildren(List<ASTNode> list) {
		for (ASTNode child : children) {
			list.add(child);
			child.allChildren(list);
		}
		return list;
	}

	public List<ASTNode> searchAll(Predicate predicate) {
		List<ASTNode> list = new LinkedList<>();
		searchAll(predicate, list);
		return list;
	}

	public void searchAll(Predicate predicate, List<ASTNode> list) {
		if (predicate.eval(this)) list.add(this);
		for (ASTNode node : children) {
			node.searchAll(predicate, list);
		}
	}

	public int searchChildren(Predicate pred) {
		return searchChildren(pred, 0);
	}

	public int searchChildren(Predicate pred, int startIndex) {
		return searchChildren(pred, startIndex, children.size());
	}

	public int searchChildren(Predicate pred, int startIndex, int endIndexExclusive) {
		endIndexExclusive = Math.min(endIndexExclusive, children.size());
		for (int i = startIndex; i < endIndexExclusive; i++) {
			if (pred.eval(children.get(i))) return i;
		}
		return -1;
	}

	public ASTNode searchForParsedNodeWithType(final String type) {
		if (type == null) return null;
		return search(new Predicate() {
			@Override
			public boolean eval(ASTNode node) {
				return type.equals(node.type);
			}
		});
	}

	public interface Action {
		void run(ASTNode node);
	}

	public interface Predicate {
		boolean eval(ASTNode node);
	}

	public static class TypePredicate implements Predicate {
		private final String[] types;

		public TypePredicate(String... types) {
			this.types = types;
		}

		@Override
		public boolean eval(ASTNode node) {
			return node != null && node.hasType(types);
		}
	}

	public static class BackbonePredicate implements Predicate {
		private final String[] backbone;

		public BackbonePredicate(String... backbone) {
			this.backbone = backbone;
		}

		@Override
		public boolean eval(ASTNode node) {
			for (int i = backbone.length - 1; i >= 0; i--) {
				String toMatch = backbone[i];
				if (toMatch.equals("...")) {
					if (i == 0) break;
					toMatch = backbone[i - 1];
					while (node != null && !matches(toMatch, node.type)) node = node.parent;
					continue;
				}
				if (node == null || !matches(toMatch, node.type)) return false;
				node = node.parent;
			}
			return true;
		}

		private static boolean matches(String toMatch, String type) {
			if (toMatch.contains("|")) {
				String[] parts = toMatch.split("\\|");
				for (String part : parts) {
					if (part.equals(type)) return true;
				}
				return false;
			} else {
				return toMatch.equals(type);
			}
		}
	}

	public static class ConjunctionPredicate implements Predicate {
		private final Predicate predicates[];
		private final boolean and;

		public ConjunctionPredicate(boolean and, Predicate... predicates) {
			this.and = and;
			this.predicates = predicates;
		}

		@Override
		public boolean eval(ASTNode node) {
			for (Predicate pred : predicates) {
				if (pred.eval(node) != and) return !and;
			}
			return and;
		}
	}

	public boolean shallowEquals(ASTNode node) {
		if (node == null) return false;
		return eq(type, node.type) && eq(value, node.value);
	}

	private boolean eq(String a, String b) {
		if (a == null) return b == null;
		return a.equals(b);
	}

	public String parentType() {
		return parent == null ? null : parent.type;
	}

	public boolean parentHasType(String... types) {
		return parent != null && parent.hasType(types);
	}

	public boolean childHasType(String type, int index) {
		return index < children.size() && children.get(index).hasType(type);
	}

	public boolean hasType(String... types) {
		return Arrays.stream(types).anyMatch(t -> this.type.equals(t));
	}

	public boolean isEquivalent(ASTNode node) {
		if (node == null) return false;
		if (!node.type.equals(this.type)) return false;
		if (!node.value.equals(this.value)) return false;
		if (node.children.size() != this.children.size()) return false;
		for (int i = 0; i < this.children.size(); i++) {
			if (!this.children.get(i).isEquivalent(node.children.get(i))) return false;
		}
		return true;
	}
}
