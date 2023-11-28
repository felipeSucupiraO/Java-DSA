package javadsa.algorithms;

public class MergeSort {
    // mergeSort: recieves the array to be sorted, the index of the first element
    // (usually 0) and the index of the last element (the size - 1) and sorts
    // the array
    public static void mergeSort(int[] array, int p, int r) {
        int q;
        if (p < r) {
            q = (int)Math.floor((p + r) / 2);
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    // merge: is an auxiliar function to the mergeSort. Recieves the array
    // containing two sorted subarrays array[p...q] and array[q + 1...r]
    // and merge them into one sorted subarray
    private static void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = array[p + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = array[q + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = left[i];
            k++;
            i++;
        }
        while (j < n2) {
            array[k] = right[j];
            k++;
            j++;
        }
    }
}