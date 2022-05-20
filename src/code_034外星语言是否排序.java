import java.util.HashMap;

public class code_034外星语言是否排序 {
    public static void main(String[] args) {
        new Solution().isAlienSorted(new String[]{"hello", "hello"}, "hlabcdefgijkmnopqrstuvwxyz");
    }

    static class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] arr = new int[order.length()];
            for (int i = 0; i < order.length(); i++) arr[order.charAt(i) - 'a'] = i;
            int index = 0;
            while (index < words.length - 1) {
                String str1 = words[index];
                String str2 = words[index + 1];
                int k = 0;
                int minLength = Math.min(str1.length(), str2.length());
                while (k <= minLength) {
                    if (k < minLength && arr[str1.charAt(k) - 'a'] > arr[str2.charAt(k) - 'a']) return false;
                    if (k < minLength && arr[str1.charAt(k) - 'a'] < arr[str2.charAt(k) - 'a']) break;
                    if (k == minLength && str1.length() > str2.length()) return false;
                    k++;
                }
                index++;
            }
            return true;
        }
    }

    static class Solution1 {
        public boolean isAlienSorted(String[] words, String order) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                map.put(c, i);
            }
            int index = 0;
            while (index < words.length - 1) {
                String str1 = words[index];
                String str2 = words[index + 1];
                int k = 0;
                int minLength = Math.min(str1.length(), str2.length());
                while (k <= minLength) {
                    if (k < minLength && map.get(str1.charAt(k)) > map.get(str2.charAt(k))) return false;
                    if (k < minLength && map.get(str1.charAt(k)) < map.get(str2.charAt(k))) break;
                    if (k == minLength && str1.length() > str2.length()) return false;
                    k++;
                }
                index++;
            }
            return true;
        }
    }
}
