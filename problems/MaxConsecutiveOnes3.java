package org.example;

public class MaxConsecutiveOnes3 {

    public static int solution(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int numZeros = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeros++;
            }

            while (numZeros > k) {
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
        System.out.println(solution(new int[]{1, 0, 1, 1, 0, 1, 1, 0, 1}, 2)); // should return 7
        System.out.println(solution(new int[]{1, 0, 1, 1, 0, 1, 1, 0, 1}, 1)); // should return 5
        System.out.println(solution(new int[]{1, 0, 1, 1, 0, 1, 1, 0, 1}, 0)); // should return 2
        System.out.println(solution(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2)); // should return 6
    }
}
