public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i : values)
    {
        if (values[i] >=0)
        {
                sum += values[i];
        }
        else
        {
            sum += values[i];
        }
    }
    return sum;
}
