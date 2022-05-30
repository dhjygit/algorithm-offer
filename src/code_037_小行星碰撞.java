import java.util.Stack;

public class code_037_小行星碰撞 {
    public static void main(String[] args) {
    }

    static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            while (index < asteroids.length) {
                if (stack.isEmpty() || stack.peek() < 0 || asteroids[index] > 0) stack.push(asteroids[index]);
                else if (stack.peek() <= -asteroids[index] && stack.pop() < -asteroids[index]) continue;
                index++;
            }
            int[] ans = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) ans[i] = stack.pop();
            return ans;
        }
    }

    static class Solution1 {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            for (int asteroid : asteroids) {
                int cur = asteroid;
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(cur);
                        break;
                    }
                    int pre = stack.peek();
                    if (pre > 0 && cur > 0 || pre < 0 && cur < 0 || pre < 0 && cur > 0) {
                        stack.push(cur);
                        break;
                    }
                    if (pre > 0 && cur < 0) if (Math.abs(pre) == Math.abs(cur)) {
                        stack.pop();
                        break;
                    } else {
                        cur = Math.abs(pre) > Math.abs(cur) ? pre : cur;
                        stack.pop();
                    }
                }
            }
            int[] ans = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) ans[i] = stack.pop();
            return ans;
        }
    }
}
