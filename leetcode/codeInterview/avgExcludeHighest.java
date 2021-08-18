class avgExcludeHighest {

    public static void main(String[] args) {
        int arr[] = {10, 10, 10, 1};

    
        System.out.println("res: "+ avgExcludeHighest(arr));
    }
    // PRE: values.length > 1 and each values[i] is >= 0
    public static double avgExcludeHighest(int[] values) {
        double average;
        int highestVal = values[0];
        int highestValIndex = 0;
        double sum = 0;

        for (int i = 0; i < values.length; i++ ) {
            if (values[i]>highestVal) {
                highestVal = values[i];
                highestValIndex = i;
            }
        }
        for (int i = 0; i < values.length; i++ ) {
            if (i == highestValIndex) {
                continue;
            } else {
                sum += values[i];
            }
        }
        System.out.print("sum: ");
        System.out.println(sum);

        average = sum / (values.length-1);

        return average;
    }
}