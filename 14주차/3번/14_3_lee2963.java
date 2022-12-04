import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public static int solution(String s) {
        int answer = 0;
        String[] bracket = s.split("");
        Stack<String> stack = new Stack<>();
        Queue<String> q = new LinkedList<>();

        for (int i = 0; i < bracket.length; i++) {
            q.add(bracket[i]);
        }

        for (int i = 0; i < bracket.length; i++) {
            boolean chk = true;
            for (int j = 0; j < bracket.length; j++) {
                String target = q.poll();
                if (target.equals("(") || target.equals("{") || target.equals("[")) {
                    stack.push(target);
                } else if (target.equals(")")) {
                    if (!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else{
                        chk = false;
                    }
                } else if(target.equals("}")){
                    if (!stack.isEmpty() && stack.peek().equals("{")) {
                        stack.pop();
                    } else{
                        chk = false;
                    }

                } else if (target.equals("]")) {
                    if (!stack.isEmpty() && stack.peek().equals("[")) {
                        stack.pop();
                    } else{
                        chk = false;
                    }
                }
                q.add(target);
            }
            if(chk && stack.isEmpty()){
                answer++;
            }

            q.add(q.poll());
            stack.clear();
        }

        return answer;
    }
}