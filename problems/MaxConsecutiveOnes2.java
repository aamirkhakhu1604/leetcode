
class MaxConsecutiveOnes2 {
  
  public int Solution(int[] nums) {
    int left = 0;
    int right = 0;
    int max = 0;
    int numZeros = -1;

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
}
