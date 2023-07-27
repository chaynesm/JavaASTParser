public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int temp : values)
	    {
	        if (positivesOnly)
	        {
	            if (values >= 0)
	            {
	                sum += values;
	            }
	        }
	        else
	        {
	            sum += values;
	        }
	    }
	    return sum;
	}

}
