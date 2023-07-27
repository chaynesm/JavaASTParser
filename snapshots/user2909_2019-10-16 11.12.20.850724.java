public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i = 0; i < values.length; i++)
    {
       if ((positivesOnly && values[i] > -1) || !positivesOnly)
    sum += values[i];
    }
    return sum;
}