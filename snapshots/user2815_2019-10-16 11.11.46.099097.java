public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum;
    for (int i : values)
    {
        if (positivesOnly)
        {
            if (i >= 0)
            {
                sum += i;
            }
        }
        else
        {
            sum += i;
        }
    }
    return sum;
}