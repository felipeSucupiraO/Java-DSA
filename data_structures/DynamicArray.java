public class DynamicArray<T> {
    
    /* 
     * Properties
     */
    private T[] array;
    private int length;     //the length the user thinks the array is
    private int capacity;   //the array's actual length

    /* 
     * Constructors
     */
    public DynamicArray(int length) {
        this.capacity = length;
        this.length = length;
        array = (T[]) new Object[length];
    }

    public DynamicArray() {
        capacity = 1;
        length = 1;
        array = (T[]) new Object[1];
    }
    
    /* 
    * Methods
    */
    public int length() {
        return length;
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public T get (int index) {
        return array[index];
    }
    
    public void set(int index, T element) {
        array[index] = element;
    }

    public void delete(int index) {
        T[] tempArray = (T[]) new Object[length - 1];

        int j = 0;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                continue;
            }
            else {
                tempArray[j] = array[i];
                j++;
            }
        }

        array = tempArray;
        length--;
    }

    public void append(T element) {
        T[] tempArray;
        
        if (length + 1 < capacity) {
            array[length + 1] = element;
        }
        else {
            if (capacity == 0) {
                capacity = 1;
            }

            tempArray = (T[]) new Object[capacity * 2];

            for (int i = 0; i < length; i++) {
                tempArray[i] = array[i];
            }

            tempArray[length] = element;
            array = tempArray;
        }
        
        length++;
    }

    public void insert(int index, T element) {
        T[] tempArray;

        if (capacity == 0) {
            capacity = 1;
        }

        if (length + 1 > capacity) {
            tempArray = (T[]) new Object[capacity * 2];
            capacity = capacity * 2;
        }
        else {
            tempArray = (T[]) new Object[capacity];
        }

        
        int j = 0;
        for (int i = 0; i < length + 1; i++) {
            if (i != index) {
                tempArray[i] = array[j];
                j++;
            }
            else {
                tempArray[i] = element;
            }
        }
        
        array = tempArray;
        length++;
    }

    public String toString() {
        if (length == 0) {
            return "[]";
        }
        
        String result = "[";
        for (int i = 0; i < length; i++) {
            if (array[i] == null) { 
                result = result + " ,";
            }
            else if (i == length - 1) {
                result = result + array[i].toString();
            }
            else {
                result = result + array[i].toString() + ",";
            }
        }

        result += "]";
        return result;  
    }
}