import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.isEmpty()) {
                if (stack.peek() == cur) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(cur);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}