import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        PriorityQueue<String> cq = new PriorityQueue<>();
        pq.addAll(Arrays.asList(participant));
        cq.addAll(Arrays.asList(completion));

        while (!cq.isEmpty()) {
            String s1 = pq.poll();
            String s2 = cq.poll();
            if (!s1.equals(s2)) {
                return s1;
            }
        }

        return pq.poll();
    }
}
