package edu.isnap.javaparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.LiteralExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithIdentifier;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import com.github.javaparser.metamodel.NodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;

public class ASTParser {

	private static final String FILE_PATH = "./src/Test.java";

	public static void main(String[] args) throws FileNotFoundException {
		CompilationUnit cu = JavaParser.parse(new FileInputStream(FILE_PATH));
		ASTNode node = parseAST(cu);
		System.out.println("Whole code AST");
		System.out.println(node);
		System.out.println("\n");


		// Find an IfStmt with a BinaryExrp as a child
		ASTNode and = node.search(new ASTNode.BackbonePredicate("IfStmt", "BinaryExpr"));
		// If it exists and it's an AND operator...
		if (and != null && and.value == "AND") {
			System.out.println("Found an if with an AND condition!");
			System.out.println(and.parent);
			System.out.println("\n");

			// Get the children of the AND, the two operands
			ASTNode expr1 = and.children.get(0);
			ASTNode expr2 = and.children.get(1);

			// Then check if there are any standalone if statements with those expressions
			List<ASTNode> ifs = node.searchAll(new ASTNode.TypePredicate("IfStmt"));

			ASTNode if1 = null, if2 = null;

			for (ASTNode ifStmt : ifs) {
				// Get the condition of the if, which should be its first child
				ASTNode condition = ifStmt.children.get(0);

				// Check if the condition is the same as either operand of the AND
				// isEquivalent checks if the types, values, and children are equivalent
				if (condition.isEquivalent(expr1)) {
					if1 = ifStmt;
					System.out.println("Found first expression in a standalone if:");
					System.out.println(ifStmt);
					System.out.println("\n");
				}
				if (condition.isEquivalent(expr2)) {
					if2 = ifStmt;
					System.out.println("Found second expression in a standalone if:");
					System.out.println(ifStmt);
					System.out.println("\n");
				}

				// If we found both, see if one is nested inside of the other.
				if (if1 != null && if2 != null) {
					if (if2.allChildren().contains(if1) || if1.allChildren().contains(if2)) {
						// If, so the refactoring is similar and likely good
						System.out.println("The standalone ifs are nested correctly!");
					} else {
						System.out.println("Ifs are disjoint, probably not nested correctly");
					}
				}
			}

		}

	}

	public static SimpleName getSimpleName(Node node) {
    	if (node == null) return null;
    	SimpleName name = null;
    	for (Node n : node.getChildNodes()) {
            // If there's one SimpleName, use that; otherwise, null
    		if (n instanceof SimpleName) {
    			if (name == null) {
    				name = (SimpleName) n;
    			}
    			else {
    				return null;
    			}
    		}
    	}
    	return name;
    }

	static boolean ignore(Node node) {
		// Don't put these nodes into the AST, since they should be
		// interpreted as values, or just ignored.
    	return
    			(node instanceof SimpleName &&
					getSimpleName(node.getParentNode().orElse(null)) == node) ||
    			node instanceof PackageDeclaration ||
    			node instanceof ImportDeclaration;
    }

	public static String getVal(Node node) {
		if (node instanceof NodeWithIdentifier) {
    		return ((NodeWithIdentifier<?>) node).getIdentifier();
    	}
		else if (node instanceof LiteralExpr) {
    		return node.toString();
    	}
    	else if (node.getChildNodesByType(SimpleName.class).size() == 1) {
    		return node.getChildNodesByType(SimpleName.class).get(0).getIdentifier();
    	}
    	else if (getSimpleName(node) != null) {
    		return getSimpleName(node).getIdentifier();
    	}
    	return "";
	}

	public static ASTNode parseAST(Node node) {
		String[] methodsToIgnore = {"isVarArgs", "getType", "isInterface", "getIdentifier", "getValue"};

		// Associate start and end with each node
		int[] sourceStart = {};
		int[] sourceEnd = {};
		if(node instanceof NodeWithRange) {
			try {
				sourceStart = new int[]{node.getBegin().get().line, node.getBegin().get().column};
				sourceEnd = new int[]{node.getEnd().get().line, node.getEnd().get().column};
			}
			catch(NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		ASTNode res = new ASTNode(node.getClass().getSimpleName(), getVal(node), new ArrayList<ASTNode>(), sourceStart, sourceEnd);

		// Create the AST
		for(Node child: node.getChildNodes()) {
			if(ignore(child)) {
				continue;
			}
			ASTNode _child = parseAST(child);
			res.getChildren().add(_child);
			_child.parent = res;
		}

		/*
		 * All the code below is just to handle the case that for example in binary expressions like a+b,
		 * JavaParser doesn't recognize '+' as a child node but we need that, there should be three children: 'a', 'b' and '+'.
		 *
		 * So there is some manual work involved here. We need to keep updating methodsToIgnore list as and when we encounter cases
		 * we've not observed so far. We are also adding specific cases that we need to handle like we need the Operator if the node
		 * type is BinaryExpr or we need the modifier when node type is FieldDeclaration. Based on the output on the console we decide
		 * whether a property should or should not be added as a child node. So this is essentially a screening process, not something
		 * automatically handled.
		 * */
		NodeMetaModel meta_model = node.getMetaModel();
		List<PropertyMetaModel> properties = meta_model.getDeclaredPropertyMetaModels();
		for(PropertyMetaModel property: properties) {
			if(!property.isNode()) {
				try {
					String methodName = property.getGetterMethodName();
					if(!Arrays.asList(methodsToIgnore).contains(methodName) && methodName.startsWith("get")) {
						boolean createChild = false;
						if(node instanceof FieldDeclaration || node instanceof Parameter || node instanceof VariableDeclarationExpr) {
							if(methodName.equals("getModifiers")) {
								createChild = true;
							}
						}
						else if(node instanceof BinaryExpr || node instanceof UnaryExpr || node instanceof AssignExpr) {
							if(methodName.equals("getOperator")) {
								// Rather than adding the operator type as a child, instead
								// add it as the value of the binary expression
								res.value = property.getValue(node).toString();
								continue;
							}
						}
						if(createChild) {
							ASTNode _child = new ASTNode(property.getTypeName(), property.getValue(node).toString(), new ArrayList<ASTNode>(), sourceStart, sourceEnd);
							res.getChildren().add(0, _child);
							_child.parent = res;
						}
						else {
							System.out.println("Unknown getter Methods: "+ methodName + " for node: "+ node.getClass().getName());
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}
}
