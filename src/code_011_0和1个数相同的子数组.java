import java.util.HashMap;

public class code_011_0和1个数相同的子数组 {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[]{0, 1}));
    }

    static class Solution {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int max = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] == 0 ? -1 : 1;
                if (map.containsKey(sum)) max = Math.max(max, i - map.get(sum));
                else map.put(sum, i);
            }
            return max;
        }
    }
}
