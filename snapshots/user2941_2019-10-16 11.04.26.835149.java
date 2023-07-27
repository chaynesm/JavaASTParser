public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int v : values)
    {
        if (positivesOnly)
        {
            if (v >= 0)
            {
                sum += v;
            }
        }
        else
        {
            sum += v;
        }
    }
    return sum;
}
