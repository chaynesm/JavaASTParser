public static int sumValues(int [] values, boolean positivesOnly)
{
    int sum = 0;
    for(int valItem : values) {
        if((positivesOnly && valItem >= 0) || !postivesOnly) {
            // buggycollapseif ??
            sum += valItem;
        } else {
            sum += valItem;   
        }
    }
    return sum;
}