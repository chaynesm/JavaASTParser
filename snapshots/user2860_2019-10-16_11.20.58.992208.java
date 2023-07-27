public class Exercise2 {

	public static int sumValues(int [] values, boolean positivesOnly)
	{
	    int sum = 0;
	    // for (int i = 0; i < values.length; i++)
	    // {
	    //     if (values[i] > 0 || !positivesOnly)
	    //         sum += values[i];
	    // }
	    for(int i : values)
	    {
	        if (values[i] > 0 || !positivesOnly)
	             sum += values[i];
	    }
	    return sum;
	}

}
