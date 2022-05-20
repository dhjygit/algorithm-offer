public class code_020_回文子字符串的个数 {
    public static void main(String[] args) {

    }

    static class Solution1 {
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (isValid(s, i, j)) count++;
                }
            }
            return count;
        }

        private boolean isValid(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) return false;
                l++;
                r--;
            }
            return true;
        }
    }
}

