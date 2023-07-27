public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i : values)
	    {
	
	        if (positivesOnly == true)
	        {
	            if (i >= 0)
	            {
	                sum += i;
	            }
	        }
	        else
	        {
	            sum += i;
	        }
	    }
	    return sum;
	}

}
