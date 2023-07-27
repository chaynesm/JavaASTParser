public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for (int i : values) {
	        if (positivesOnly){
	            if(i < 0){
	                sum = 0;
	            }
	        }
	        sum += i;
	    }
	    return sum;
	}

}
