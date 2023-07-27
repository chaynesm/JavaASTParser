public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i = 0; i < values.length; i++)
	    {
	        if (positivesOnly && values[i] > 0) || !positivesOnly)
	        {
	                sum += values[i];
	           
	    }
	    return sum;
	}

}
