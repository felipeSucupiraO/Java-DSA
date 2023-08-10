package javadsa;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        int key;
        
        for (int i = 1; i < array.length; i++) {
            key = array[i];

            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

        return array;
    }
}
