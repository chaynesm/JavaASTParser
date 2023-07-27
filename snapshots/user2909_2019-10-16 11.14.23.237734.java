public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    foreach(int i : values){
    {
       if ((values[i] > -1) || !positivesOnly)
            sum += values[i];
    }
    }
    return sum;
}
