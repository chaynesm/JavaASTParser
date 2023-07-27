public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int i : values)
        if (positivesOnly == false || i > 0)
            sum += i;
    return sum;
}
