public class code_070_排序数组中只出现一次的数字 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int singleNonDuplicate(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid + 1]) l = mid + 2;
                    else if (nums[mid] == nums[mid - 1]) r = mid - 2;
                    else return nums[mid];
                } else {
                    if (nums[mid] == nums[mid - 1]) l = mid + 1;
                    else if (nums[mid] == nums[mid + 1]) r = mid - 1;
                    else return nums[mid];
                }
            }
            return nums[l];
        }
    }

    static class Solution1 {
        public int singleNonDuplicate(int[] nums) {
            int ans = 0;
            for (int num : nums)
                ans ^= num;
            return ans;
        }
    }
}

