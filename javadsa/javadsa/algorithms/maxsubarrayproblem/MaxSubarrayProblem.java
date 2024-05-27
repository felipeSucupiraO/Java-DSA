package javadsa.algorithms.maxsubarrayproblem;

import java.util.Arrays;

public class MaxSubarrayProblem {
    public static int[] findMaxSubarray(int[] array) {
        MaxSubarrayProblemArray arrayObject = new MaxSubarrayProblemArray(array, 0, array.length - 1, 0);
        
        arrayObject = recursiveFindMaxSubarray(arrayObject.array, arrayObject.min, arrayObject.max);
        return Arrays.copyOfRange(arrayObject.array, arrayObject.min, arrayObject.max + 1);
    }

    private static MaxSubarrayProblemArray recursiveFindMaxSubarray(int[] array, int min, int max) {
        if (min == max) {
            return new MaxSubarrayProblemArray(array, min, max, array[min]);
        } else {
            int mid = (int)Math.floor((min + max) / 2);
            MaxSubarrayProblemArray left = recursiveFindMaxSubarray(array, min, mid);
            MaxSubarrayProblemArray right = recursiveFindMaxSubarray(array, mid + 1, max);
            MaxSubarrayProblemArray cross = findMaxCrossingSubarray(array, min, mid, max);
            
            if (left.sum >= right.sum && left.sum >= cross.sum) {
                return left;
            } else if (right.sum >= left.sum && right.sum >= cross.sum) {
                return right;
            } else {
                return cross;
            }
        }

    }

    private static MaxSubarrayProblemArray findMaxCrossingSubarray(int[] array, int left, int mid, int right) {
        int sum;

        sum = array[mid];
        int maxLeftIndex = mid;
        int leftSum = sum;
        for (int i = mid - 1; i >= left; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeftIndex = i;
            }
        }

        sum = array[mid + 1];
        int maxRightIndex = mid + 1;
        int rightSum = sum;
        for (int i = mid + 2; i <= right; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRightIndex = i;
            }
        }

        return new MaxSubarrayProblemArray(array, maxLeftIndex, maxRightIndex, leftSum + rightSum);
    }
}