
import java.util.*;

class Solution {
    public static List<Integer> solution(int n, long k) {
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        int last = n;

        while(n > 0){
            long fact = 1;

            for (int i = n; i > 1; i--) {
                fact *= i;
            }

            long num = fact / n;
            long order = k / num;
            long seq = k % num;
            int index = 0;

            for (int i = 1; i <= last; i++) {
                if(!visited[i]) {
                    index++;

                    int target = (int) order + 1;
                    if (seq == 0) {
                        target--;
                    }
                    if (index == target) {
                        answer.add(i);
                        visited[i] = true;
                    }
                }
            }

            if (seq == 0) {
                for (int i = last; i >= 1; i--) {
                    if(!visited[i])
                        answer.add(i);
                }
                break;
            } else if (seq == 1) {
                for (int i = 1; i <= last; i++) {
                    if (!visited[i])
                        answer.add(i);
                }
                break;
            }

            k = seq;
            n--;
        }
        return answer;
    }
}