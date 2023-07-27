public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for (int var : values) 
    {
        if (positivesOnly == true)
        {
            if (var >= 0)
            {
                sum += var;
            }
        }
        else
        {
            sum += var;
        }
    }


    return sum;
}
