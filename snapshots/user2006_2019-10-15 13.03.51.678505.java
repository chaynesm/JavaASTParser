public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for(int test : values) {
        if(positivesOnly){
            if(test >= 0) {
                sum += test;
            }
        } else {
            sum += test;
        }

    }
    
    return sum;
    

}
