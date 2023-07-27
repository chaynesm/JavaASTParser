public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i : values)
    {
        if (i > 0 || positivesOnly == false)
        {
            sum += i;
        }
    }
    return sum;
}
