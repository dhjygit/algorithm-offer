public class code_002_二进制加法 {
    public static void main(String[] args) {
    }

    static class Solution {
        public String addBinary(String a, String b) {
            int length = Math.max(a.length(), b.length());
            int c = 0;
            int i = a.length() - 1;
            int j = b.length() - 1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < length; k++) {
                char c1 = i >= 0 ? a.charAt(i) : '0';
                char c2 = j >= 0 ? b.charAt(j) : '0';
                int result = c1 + c2 - '0' - '0' + c;
                c = result / 2;
                stringBuilder.append(result % 2);
                i--;
                j--;
            }
            if (c > 0) stringBuilder.append('1');
            return stringBuilder.reverse().toString();
        }
    }
}
