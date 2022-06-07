public class code_068_查找插入位置 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (target == nums[mid]) return mid;
                else if (target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            }
            return l;
        }
    }
}

