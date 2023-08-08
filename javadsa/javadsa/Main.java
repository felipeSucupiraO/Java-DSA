package javadsa;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{10, 5, 6, 3, 7, 1, 2, 9, 4, 8};
    
        InsertionSort.insertionSort(array);
        System.out.println(array);
    }
}
