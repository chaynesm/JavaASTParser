public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int value : values)
    {
        if (positivesOnly && value >= 0 || !positivesOnly)
        {
            sum += value;
        }
    }
    return sum;
}
