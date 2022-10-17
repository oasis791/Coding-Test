import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        Arrays.stream(priorities).forEach(pq::offer);

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }

        return answer;

        /*
         * int index = -1;
         * int big = 0;
         * int same = 0;
         * for (int i = 0; i < priorities.length; i++) {
         * if (priorities[location] < priorities[i]) {
         * if (index == -1) index = i;
         * big++;
         * if (priorities[index] >= priorities[i]) index = i;
         * }
         * if (priorities[location] == priorities[i]) same++;
         * }
         * 
         * if (index == -1) {
         * if (same == 1) return 1;
         * index = 0;
         * }
         * 
         * int order = 0;
         * while (true) {
         * if (index == priorities.length) index = 0;
         * 
         * if (index == location) {
         * order++;
         * break;
         * }
         * 
         * if (priorities[index++] == priorities[location]) order++;
         * }
         * 
         * return big + order;
         */
    }
}
