public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i : values)
	    {
	        if (positivesOnly == true && i >= 0)
	        {
	                sum += i;
	        }
	        if (PositivesOnly == false)
	        {
	            sum += i;
	        }
	    }
	    return sum;
	}

}
