public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    if (positivesOnly){
	        for (int value : values)
	    {
	        if (positivesOnly)
	        {
	            if (value >= 0)
	            {
	                sum += value;
	            }
	        }
	    }
	    }
	    
	    return sum;
	}

}
