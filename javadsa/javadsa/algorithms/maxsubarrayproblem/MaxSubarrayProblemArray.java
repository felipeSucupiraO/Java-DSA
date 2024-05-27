package javadsa.algorithms.maxsubarrayproblem;

// this is a supportive class for the subarray problem
// it is just a way to return three values in the function
public class MaxSubarrayProblemArray {
    public int[] array;
    public int min;
    public int max;
    public int sum;
    
    public MaxSubarrayProblemArray(int[] array, int min, int max, int sum) {
        this.array = array;
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}