public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i: values)
    {
        if (positivesOnly && i > 0)
        {
            if (i > 0)
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
