public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for(int val : values){
        if (!positivesOnly || val > -1)
        {
            sum += val;
        }
    }
    return sum;
}
