public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int tel : values)
    {
        if (positivesOnly == true)
        {
            if (values[i] >= 0)
            {
                sum += tel;
            }
        }
        else
        {
            sum += tel;
        }
    }
    return sum;
}
