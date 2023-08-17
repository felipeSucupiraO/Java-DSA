package javadsa.algorithms;

public class CountingSort {
    public static int[] countingSort(int[] a, int k) {
        int[] c = new int[k];
        
        // this for loop adds the values to array c, where each element has a value equal to the amount of times it's index plus one appears in a
        for (int i = 0; i < a.length; i++) {
            c[a[i] - 1]++;
        }

        // this loop gets the c array ready by making so each element is the sum of all the elements before
        for (int i = 1; i < k ; i++) {
            c[i] = c[i] + c[i - 1];
        }

        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i] - 1] - 1] = a[i];
            c[a[i] - 1]--;
        }

        a = b;
        return a;
    }
}