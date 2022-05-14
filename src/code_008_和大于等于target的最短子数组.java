public class code_008_和大于等于target的最短子数组 {
    public static void main(String[] args) {
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int l = 0;
            int r = 0;
            while (r < nums.length) {
                sum += nums[r];
                while (l <= r && sum >= target) {
                    min = Math.min(min, r - l + 1);
                    sum -= nums[l];
                    l++;
                }
                r++;
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}
