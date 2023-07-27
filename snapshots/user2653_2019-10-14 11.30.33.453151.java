public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int tmp_arrIt : values)
    {
        if ((positivesOnly && tmp_arrIt >= 0) || !positivesOnly)
    sum += tmp_arrIt;
    }
    return sum;
}
