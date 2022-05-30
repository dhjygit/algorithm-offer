import java.util.HashMap;

public class code_016_不含重复字符的最长子字符串 {
    public static void main(String[] args) {
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] arr = new int[128];
            int max = 0;
            int l = 0;
            int r = 0;
            while (r < s.length()) {
                arr[s.charAt(r)] += 1;
                while (arr[s.charAt(r)] > 1) {
                    arr[s.charAt(l)] -= 1;
                    l++;
                }
                max = Math.max(max, r - l + 1);
                r++;
            }
            return max;
        }
    }

    static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            int l = 0;
            int r = 0;
            while (r < s.length()) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                while (map.get(s.charAt(r)) > 1) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                }
                max = Math.max(max, r - l + 1);
                r++;
            }
            return max;
        }
    }
}
