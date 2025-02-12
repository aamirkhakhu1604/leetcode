import java.util.Arrays;

class MaxSubArraySum {

    // Function to find the maximum subarray sum
    static int maxSubarraySum(int[] arr) {
        int curSum = 0;
        int maxSum = 0;
        // Outer loop for starting point of subarray
        for (int i = 0; i < arr.length; i++) {
            curSum = curSum + arr[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }
}
