public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i = 0 : values.length)
	    {
	        if (!positivesOnly || values[i] > 0)
	        {
	            sum += values[i];
	        }
	
	    }
	    return sum;
	}

}
