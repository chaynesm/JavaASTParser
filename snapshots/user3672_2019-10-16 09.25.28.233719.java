public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i : values)
    {
        if (!positivesOnly || values > 0)
        {
            sum += values;
        }
        i++;

    }
    return sum;
}
