package org.example;

/*
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
*/
class MaxConsecutiveOnes2 {

    public static int solution(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        int numZeros = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeros++;
            }

            while (numZeros >= 2) {
                if (nums[left] == 0) {
                    numZeros--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 0, 1, 1, 0})); // should return 4
        System.out.println(solution(new int[]{1, 0, 1, 1, 0, 1})); // should return 4
        System.out.println(solution(new int[]{1, 0, 1, 1, 0, 1, 1, 0, 1})); // should return 5
    }
}
