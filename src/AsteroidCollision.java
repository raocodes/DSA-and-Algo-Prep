import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        for (int ast : asteroids) {
            if (ast > 0) {
                stk.push(ast);
            } else {
                while (!stk.isEmpty() && stk.peek() > 0 && stk.peek() < Math.abs(ast)) {
                    stk.pop();
                }

                if (stk.isEmpty()) {
                    stk.push(ast);
                } else if (stk.peek() > 0 && stk.peek() == Math.abs(ast)) {
                    stk.pop();
                } else if (stk.peek() < 0) {
                    stk.push(ast);
                }
            }
        }

        int[] result = new int[stk.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stk.pop();
        }

        return result;
    }
}
