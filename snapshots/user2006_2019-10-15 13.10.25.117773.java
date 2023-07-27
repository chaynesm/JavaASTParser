public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int test : values)
    {
        if ((positivesOnly && test > 0) || !positivesOnly)
        {
            sum += test;
        }
    }
    return sum;
}
