public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for(int valItem : values) {
	        if(positivesOnly) {
	            sum += valItem;
	        }
	        sum += valItem;
	    }
	    return sum;
	}

}
