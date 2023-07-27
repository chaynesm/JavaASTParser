public static int sumValues(int [] v, boolean positivesOnly)
{
    int sum = 0;
    for (int i : v)
    {
        if (positivesOnly == false || i > 0)
        {
            sum += i;
        }
    }
    return sum;
}
