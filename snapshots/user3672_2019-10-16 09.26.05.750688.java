public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i : values)
    {
        if (!positivesOnly || values.length > 0)
        {
            sum += i;
        }
        i++;

    }
    return sum;
}
