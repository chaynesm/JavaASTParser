public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int tel : values)
	    {
	        if (positivesOnly  && tel > 0)
	        {
	         
	               sum += tel;
	               
	        }
	        else
	        {
	            sum += tel ;
	        }
	    }
	    return sum;
	}

}
