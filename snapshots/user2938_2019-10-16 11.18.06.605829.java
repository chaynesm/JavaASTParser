public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int val : values)
    {
        if (positivesOnly)
        {
            if (val > -1)
            {
                sum += val;
            }
        }
        else
        {
            sum += val;
        }
    }
    return sum;
}
