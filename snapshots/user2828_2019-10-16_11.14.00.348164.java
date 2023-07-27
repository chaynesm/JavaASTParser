public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    for(int valItem : values) {
	        if(valItem >= 0 && positivesOnly) {
	            // buggycollapseif ??
	            sum += valItem;
	        } else {
	            sum += valItem;   
	        }
	    }
	    return sum;
	}

}
