public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int value : values)
	    {
	        if (positivesOnly){
	            if(value > 0){
	                sum += value;
	            }
	            
	        }
	        else{
	            sum += value;
	        }
	    }
	    return sum;
	}

}
