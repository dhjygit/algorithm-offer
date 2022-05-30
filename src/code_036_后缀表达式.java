import java.util.Stack;

public class code_036_后缀表达式 {
    public static void main(String[] args) {
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens)
                switch (token) {
                    case "+": {
                        Integer next = stack.pop();
                        Integer pre = stack.pop();
                        stack.push(pre + next);
                        break;
                    }
                    case "-": {
                        Integer next = stack.pop();
                        Integer pre = stack.pop();
                        stack.push(pre - next);
                        break;
                    }
                    case "*": {
                        Integer next = stack.pop();
                        Integer pre = stack.pop();
                        stack.push(pre * next);
                        break;
                    }
                    case "/": {
                        Integer next = stack.pop();
                        Integer pre = stack.pop();
                        stack.push(pre / next);
                        break;
                    }
                    default:
                        stack.push(Integer.valueOf(token));
                        break;
                }
            return stack.pop();
        }
    }
}
