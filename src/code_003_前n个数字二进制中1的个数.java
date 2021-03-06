public class code_003_前n个数字二进制中1的个数 {
    public static void main(String[] args) {
    }

    static class Solution {
        public int[] countBits(int n) {
            int[] result = new int[n + 1];
            for (int i = 0; i <= n; i++) result[i] = getBitCount(i);
            return result;
        }

        private int getBitCount(int n) {
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) count++;
                n >>= 1;
            }
            return count;
        }
    }

    static class Solution1 {
        public int[] countBits(int n) {
            int[] result = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int temp = i;
                int count = 0;
                while (temp != 0) {
                    if (temp % 2 == 1) count++;
                    temp = temp >> 1;
                }
                result[i] = count;
            }
            return result;
        }
    }

    class Solution2 {
        public int[] countBits(int n) {
            int[] result = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                String str = Integer.toBinaryString(i);
                System.out.println(str);
                int count = 0;
                for (int j = 0; j < str.length(); j++) if (str.charAt(j) == '1') count++;
                result[i] = count;
            }
            return result;
        }
    }
}
