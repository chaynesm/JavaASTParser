public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (value : values)
    {
        if (positivesOnly == true)
        {
            if (value >= 0)
            {
                sum += value;
            }
        }
        else
        {
            sum += value;
        }
    }
    return sum;
}