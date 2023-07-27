public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    if(positivesOnly) {
	        for (int value : values) {
	            if (value > 0) {
	                sum += value;
	            }
	        }
	    } else {
	           for (int value : values) {
	                sum += value;
	            }
	        }
	    
	    return sum;
	}

}
