public class Exercise2 {

	static int sumValues(int[] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i : values)
	    {
	        if (positivesOnly && i >= 0)
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