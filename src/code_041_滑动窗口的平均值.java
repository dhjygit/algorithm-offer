import java.util.LinkedList;
import java.util.Queue;

public class code_041_滑动窗口的平均值 {
    public static void main(String[] args) {
    }

    static class MovingAverage {
        private final Queue<Integer> queue;
        private final int size;
        private double sum;

        public MovingAverage(int size) {
            this.size = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            queue.offer(val);
            sum += val;
            if (queue.isEmpty()) return sum;
            if (queue.size() > size) sum -= queue.poll();
            return sum / queue.size();
        }
    }

    static class MovingAverage1 {
        private final Queue<Integer> queue;
        private final int size;
        private double sum;

        public MovingAverage1(int size) {
            this.size = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            if (queue.size() == size) sum -= queue.poll();
            queue.offer(val);
            sum += val;
            return sum / queue.size();
        }
    }
}
