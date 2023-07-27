public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i = 0; i < values.length; i++)
    {
        if (positivesOnly)
        {
            if ((positivesOnly && values[i] > 0) || !positivesOnly)
            {
                sum += values[i];
            }
        }
        else
        {
            sum += values[i];
        }
    }
    return sum;
}