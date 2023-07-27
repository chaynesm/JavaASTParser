public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    
    for(int val: values){
        if (positivesOnly==true && val >= 0)
        {
               sum += val;
        }
        elseif(val<=0)
        {
            sum += val;
        }
        
    }
    return sum;
}
