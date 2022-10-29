import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    int INF = Integer.MAX_VALUE;
    int[] dist;
    boolean[] visited;
    List<Node>[] graph;
    class Node implements Comparable<Node>{
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < road.length; i++) {
            graph[road[i][0]].add(new Node(road[i][1], road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.v] = true;

            for (Node next : graph[cur.v]) {
                if (!visited[next.v]) {
                    if (dist[next.v] > cur.dist + next.dist) {
                        dist[next.v] = cur.dist + next.dist;
                        pq.add(new Node(next.v , dist[next.v]));
                    }
                }
            }
        }
    }
}