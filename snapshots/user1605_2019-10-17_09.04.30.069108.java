public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum;
	    for (int value : values)
	        if ((positivesOnly && value >= 0)||!positivesOnly)
	                sum += value;
	    return sum;
	}

}
