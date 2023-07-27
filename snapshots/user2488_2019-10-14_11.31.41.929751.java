public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    if(positivesOnly) {
	        for (int value : values) {
	            if (value >= 0) {
	                sum += values[i];
	            }
	        }
	    } else
	        {
	            sum += IntStream.of(values).sum();;
	        }
	    
	    return sum;
	}

}
