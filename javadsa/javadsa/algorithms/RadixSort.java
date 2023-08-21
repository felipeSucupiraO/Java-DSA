package javadsa.algorithms;

public class RadixSort {
    public static int[] radixSort(int[] array, int digits, int largestNumber) {
        for (int j = 0; j < digits; j++) {
            
            // the following code is the counting sort modified to work in the radix sort
            // note that the radix sort accepts any stable sort to sort the array elements on the current digit. The counting sort is commonly used
            int[] c = new int[largestNumber];
        
            for (int i = 0; i < array.length; i++) {
                int number = toDigit(array[i], j);

                c[number - 1]++;
            }
    
            for (int i = 1; i < largestNumber ; i++) {
                c[i] = c[i] + c[i - 1];
            }
    
            int[] b = new int[array.length];
            for (int i = array.length - 1; i >= 0; i--) {
                int number = toDigit(array[i], j);

                b[c[number - 1] - 1] = array[i];
                c[number - 1]--;
            }
    
            array = b;
        }

        return array;
    }

    private static int toDigit(int num, int digit) {
        String stringNumber = String.valueOf(num);
        char[] charArray = stringNumber.toCharArray();

        char charDigit = charArray[(charArray.length - 1) - digit];

        int finalDigit = Character.getNumericValue(charDigit);

        return finalDigit;
    }
}