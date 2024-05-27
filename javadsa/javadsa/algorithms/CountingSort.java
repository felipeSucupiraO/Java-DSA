package javadsa.algorithms;

public class CountingSort {
    public static int[] countingSort(int[] array, int largestNumber) {
        int[] c = new int[largestNumber];
        
        // this for loop adds the values to array c, where each element has a value equal to the amount of times it's index plus one appears in a
        for (int i = 0; i < array.length; i++) {
            c[array[i] - 1]++;
        }

        // this loop gets the c array ready by making so each element is the sum of all the elements before
        for (int i = 1; i < largestNumber ; i++) {
            c[i] = c[i] + c[i - 1];
        }

        int[] b = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            b[c[array[i] - 1] - 1] = array[i];
            c[array[i] - 1]--;
        }

        array = b;
        return array;
    }
}