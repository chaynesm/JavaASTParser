public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int tmp_arrIt : values)
	    {
	        if (positivesOnly)
	        {
	            if (tmp_arrIt > 0)
	            {
	                sum += tmp_arrIt;
	            }
	        }
	        else 
	        {
	            sum += tmp_arrIt;
	        }
	    }
	    return sum;
	}

}
