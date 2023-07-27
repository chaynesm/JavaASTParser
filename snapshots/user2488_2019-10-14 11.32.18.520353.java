public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    if(positivesOnly) {
        for (int value : values) {
            if (value >= 0) {
                sum += value;
            }
        }
    } else
        {
            sum += IntStream.of(values).sum();
        }
    
    return sum;
}
