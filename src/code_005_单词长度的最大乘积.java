import java.util.HashSet;

public class code_005_单词长度的最大乘积 {
    public static void main(String[] args) {
    }

    static class Solution {
        public int maxProduct(String[] words) {
            int max = 0;
            int[] arr = new int[words.length];
            for (int i = 0; i < arr.length; i++) {
                String str = words[i];
                int value = 0;
                for (int j = 0; j < str.length(); j++) value |= 1 << (str.charAt(j) - 'a');
                arr[i] = value;
            }
            for (int i = 0; i < words.length; i++)
                for (int j = i + 1; j < words.length; j++)
                    if ((arr[i] & arr[j]) == 0) max = Math.max(max, words[i].length() * words[j].length());
            return max;
        }
    }

    static class Solution1 {
        public int maxProduct(String[] words) {
            int max = 0;
            for (int i = 0; i < words.length - 1; i++) {
                HashSet<Character> set = new HashSet<>();
                for (int j = i + 1; j < words.length; j++) {
                    int a = words[i].length();
                    int b = words[j].length();
                    for (int k = 0; k < words[i].length(); k++) set.add(words[i].charAt(k));
                    for (int k = 0; k < words[j].length(); k++)
                        if (set.contains(words[j].charAt(k))) {
                            a = 0;
                            b = 0;
                            break;
                        }
                    max = Math.max(a * b, max);
                }
            }
            return 0;
        }
    }
}
