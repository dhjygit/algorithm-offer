import java.util.LinkedList;
import java.util.Queue;

public class code_042_最近请求次数 {
    public static void main(String[] args) {
    }

    static class RecentCounter {
        private final Queue<Integer> queue;
        private int count = 0;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            int start = t - 3000;
            while (!queue.isEmpty() && start > queue.peek()) {
                count--;
                queue.poll();
            }
            queue.offer(t);
            count++;
            return count;
        }
    }
}
