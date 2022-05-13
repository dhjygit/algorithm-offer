public class code_012_左右两边子数组的和相等 {
    public static void main(String[] args) {
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            int total = 0;
            for (int num : nums) total += num;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum * 2 - nums[i] == total) return i;
            }
            return -1;
        }
    }

    static class Solution1 {
        public int pivotIndex(int[] nums) {
            int[] arr = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                arr[i] = sum;
            }
            for (int i = 0; i < nums.length; i++) {
                int left = arr[i] - nums[i];
                int right = arr[nums.length - 1] - arr[i];
                if (left == right) return i;
            }
            return -1;
        }
    }
}