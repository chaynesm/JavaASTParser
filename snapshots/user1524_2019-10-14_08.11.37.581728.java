public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int value : values)
	    {
	            if (value > 0 && positivesOnly == true)
	            {
	                sum += value;
	            }
	        
	        else
	        {
	            sum += value;
	        }
	    }
	    return sum;
	}

}
