public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i = 0; i < values.length; i++)
	    {
	            if (values[i] > 0 && positivesOnly == true)
	            {
	                sum += values[i];
	            }
	        
	        else
	        {
	            sum += values[i];
	        }
	    }
	    return sum;
	}

}
