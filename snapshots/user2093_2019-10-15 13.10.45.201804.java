public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i : values)
    {
        if ((positivesOnly && i >= 0) || !positivesOnly)
        {
            sum += i;
        }
    }
    return sum;
}
