public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    /*for (int i = 0; i < values.length; i++)
	    {
	        if (positivesOnly == true)
	        {
	            if (values[i] >= 0)
	            {
	                sum += values[i];
	            }
	        }
	        else
	        {
	            sum += values[i];
	        }
	    }*/
	    for(int value : values) {
	        if(positivesOnly == true && value >= 0) {
	            sum += value;
	        } else {
	            sum += value;
	        }
	    }
	    return sum;
	}

}
