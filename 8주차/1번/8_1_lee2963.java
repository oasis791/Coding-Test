import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        boolean chk = false;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char cur = dartResult.charAt(i);
            StringBuilder sb = new StringBuilder("");

            while (cur >= 48 && cur <= 57 ) {
                sb.append(cur);
                i++;
                cur  = dartResult.charAt(i);
                chk = true;
            }

            if(chk) {
                stack.push(Integer.parseInt(sb.toString()));
                chk = false;
            }

            switch (cur) {
                case 'S':
                    continue;
                case 'D':
                    stack.push((int) Math.pow(stack.pop(), 2));
                    break;
                case 'T':
                    stack.push((int) Math.pow(stack.pop(), 3));
                    break;
                case '*':
                    int num1 = stack.pop() * 2;
                    if (!stack.isEmpty()) {
                        stack.push(stack.pop() * 2);
                    }
                    stack.push(num1);
                    break;
                case '#':
                    stack.push(-stack.pop());
                    break;
                default:
                    break;
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}