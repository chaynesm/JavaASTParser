public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int x : values)
	    {
	        if (positivesOnly == true)
	        {
	            if (x >= 0)
	            {
	                sum += x;
	            }
	        }
	        else
	        {
	            sum += x;
	        }
	    }
	    return sum;
	}

}
