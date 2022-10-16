import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {

            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    answer++;
                    pq.poll();

                    if (i == location) {
                        System.out.println(answer);
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}