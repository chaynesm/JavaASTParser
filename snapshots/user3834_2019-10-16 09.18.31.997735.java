public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i : values)
    {
        if (positivesOnly)
        {
        }
        else
        {
            sum += i;
        }
    }
    return sum;
}
