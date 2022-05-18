public class code_019_最多删除一个字符得到回文 {
    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("eeccccbebaeeabebccceea"));
    }

    static class Solution {
        public boolean validPalindrome(String s) {
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                } else {
                    return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
                }
            }
            return true;
        }

        private boolean isPalindrome(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) return false;
                l++;
                r--;
            }
            return true;
        }
    }

    static class Solution1 {
        public boolean validPalindrome(String s) {
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    boolean flag1 = isPalindrome(new StringBuilder(s).substring(l + 1, r + 1));
                    boolean flag2 = isPalindrome(new StringBuilder(s).substring(l, r));
                    return flag1 || flag2;
                }
                l++;
                r--;
            }
            return true;
        }

        private boolean isPalindrome(String s) {
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) return false;
                l++;
                r--;
            }
            return true;
        }
    }
}
