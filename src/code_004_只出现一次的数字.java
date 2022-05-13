import java.util.HashMap;
import java.util.Map;

public class code_004_只出现一次的数字 {
    public static void main(String[] args) {

    }

    static class Solution1 {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            int result = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) return entry.getKey();
            }
            return 0;
        }
    }
}

