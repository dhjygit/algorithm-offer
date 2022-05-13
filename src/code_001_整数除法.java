public class code_001_整数除法 {
    public static void main(String[] args) {
    }

    static class Solution1 {
        public int divide(int a, int b) {
            long count = 0;
            long i = Math.abs((long) a);
            long j = Math.abs((long) b);
            boolean flag = a < 0 && b > 0 || a > 0 && b < 0;
            while (i >= j) {
                i -= j;
                count++;
            }
            count = flag ? -count : count;
            if (count > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (count < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return (int) count;
        }
    }
}

