public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    
	    for (int i = 0; i < values.length; i++)
	    {
	        if (positivesOnly && values[i] > 0)
	        {
	           
	                i += values[i];
	            
	        }
	      
	    }
	    return i;
	}

}
