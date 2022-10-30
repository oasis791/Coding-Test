import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[] shortest = new int[N + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);

        int[][] distance = new int[N + 1][N + 1];
        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int time = road[i][2];

            if (distance[start][end] != 0 && distance[start][end] < time) {
                continue;
            }

            distance[start][end] = time;
            distance[end][start] = time;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        shortest[1] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (distance[node][i] != 0) {
                    if (shortest[i] > shortest[node] + distance[node][i]) {
                        shortest[i] = Math.min(shortest[node] + distance[node][i], shortest[i]);
                        queue.offer(i);
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < shortest.length; i++) {
            if (shortest[i] <= K)
                answer++;
        }

        return answer;
    }
}
