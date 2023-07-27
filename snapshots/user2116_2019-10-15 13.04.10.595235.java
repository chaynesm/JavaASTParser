public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int value : values)
    {
        if (positivesOnly == true && values[i] >= 0)
        {
            sum += values[i];
            
        }
        
        if (!positivesOnly)
        {
            sum += values[i];
        }
    }
    return sum;
}
