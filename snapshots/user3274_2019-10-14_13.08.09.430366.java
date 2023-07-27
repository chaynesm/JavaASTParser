public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i : values)
	    {
	        if ((positivesOnly && values > 0) || !positivesOnly)
	            sum += values;
	    }
	    return sum;
	}

}
