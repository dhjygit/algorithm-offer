public class code_018_有效的回文 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.deleteCharAt(0);

    }

    static class Solution {
        public boolean isPalindrome(String s) {
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
                while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
                l++;
                r--;
            }
            return true;
        }
    }

    static class Solution1 {
        public boolean isPalindrome(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++)
                if (Character.isLetterOrDigit(s.charAt(i))) stringBuilder.append(Character.toLowerCase(s.charAt(i)));
            String str1 = stringBuilder.toString();
            String str2 = stringBuilder.reverse().toString();
            return str1.equals(str2);
        }
    }
}
