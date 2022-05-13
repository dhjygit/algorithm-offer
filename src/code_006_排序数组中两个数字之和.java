import java.util.HashMap;

public class code_006_排序数组中两个数字之和 {
    public static void main(String[] args) {
        System.out.println(2L * Integer.MAX_VALUE);
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            int i = 0;
            int j = numbers.length - 1;
            while (i < j) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                } else if (numbers[i] + numbers[j] > target) j--;
                else i++;
            }
            return result;
        }
    }

    static class Solution1 {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(target - numbers[i])) {
                    result[0] = map.get(target - numbers[i]);
                    result[1] = i;
                    break;
                }
                map.put(numbers[i], i);
            }
            return result;
        }
    }
}

