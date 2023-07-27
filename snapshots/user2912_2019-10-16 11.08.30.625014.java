public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    
    if(positivesOnly) {
        for(int i : values) {
            if(i > 0) {
                sum += i;
            }
        }
    }
    else {
        for(int i : values) {
            sum += i;
        }
    }
    return sum;
}
