public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i = 0 : values.length)
	    {
	        if (!positivesOnly || values > 0)
	        {
	            sum += values;
	        }
	
	    }
	    return sum;
	}

}
