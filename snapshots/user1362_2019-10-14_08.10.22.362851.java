public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int x : values)
	    {
	        if ((positivesOnly && x >= 0) || !positivesOnly)
	        {
	                sum += x;
	        }
	        else
	        {
	            sum += x;
	        }
	    }
	    return sum;
	}

}
