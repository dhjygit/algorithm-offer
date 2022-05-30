public class code_001_整数除法 {
    public static void main(String[] args) {
    }

    static class Solution {
        public int divide(int a, int b) {
            if (a == 0) return 0;
            if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
            boolean flag = a > 0 && b > 0 || a < 0 && b < 0;
            long aa = Math.abs((long) a);
            long bb = Math.abs((long) b);
            if (bb > aa) return 0;
            return flag ? divide(aa, bb) : -divide(aa, bb);
        }

        private int divide(long a, long b) {
            if (b > a) return 0;
            long temp = b;
            int count = 1;
            while ((temp << 1) < a) {
                count <<= 1;
                temp <<= 1;
            }
            return count + divide(a - temp, b);
        }
    }
}
