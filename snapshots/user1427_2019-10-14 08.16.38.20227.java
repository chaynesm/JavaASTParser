public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i = 0; i < values.length; i++)
    {
        if (positivesOnly)
        {
                sum += values[i];
        }
        else
        {
            sum += values[i];
        }
    }
    return sum;
}
