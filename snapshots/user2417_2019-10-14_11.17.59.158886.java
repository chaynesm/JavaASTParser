public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    
	    foreach (int value in values){
	        if(positivesOnly == true){
	            if(value >= 0){
	                sum += values;
	            }
	        }else{
	            sum += values;
	        }
	    }
	    return sum;
	}

}
