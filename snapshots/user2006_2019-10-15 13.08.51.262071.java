public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for(int test : values) {
        if(!positivesOnly || positivesOnly && test >0){
    }
        sum += test;
    }
    
    return sum;
    

}
