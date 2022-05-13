public class code_009_乘积小于K的子数组 {
    public static void main(String[] args) {
    }

    static class Solution1 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int allCount = 0;
            for (int i = 0; i < nums.length; i++) {
                long result = 1;
                int count = 0;
                for (int j = i; j < nums.length; j++) {
                    result *= nums[j];
                    if (result >= k) break;
                    count++;
                }
                allCount += count;
            }
            return allCount;
        }
    }

    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int ans = 0;
            int l = 0;
            int r = 0;
            int value = 1;
            while (r < nums.length) {
                value *= nums[r];
                while (l <= r && value >= k) value /= nums[l++];
                ans += r - l + 1;
                r++;
            }
            return ans;
        }
    }
}
