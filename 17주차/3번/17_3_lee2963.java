class Solution {
    static boolean[][] map;
    static boolean[] visited;
    static int cnt;
    public static int solution(int n, int[][] wires) {
        int answer = (n - 1) - 1;
        map = new boolean[n][n];

        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0] - 1][wires[i][1] - 1] = true;
            map[wires[i][1] - 1][wires[i][0] - 1] = true;
        }

        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0] - 1][wires[i][1] - 1] = false;
            map[wires[i][1] - 1][wires[i][0] - 1] = false;

            visited = new boolean[n + 1];
            visited[1] = true;
            cnt = 1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && map[1][j]) {
                    cnt++;
                    visited[j] = true;
                    dfs(j,  n);
                }
            }
            answer = Math.min(answer, Math.abs(Math.abs(n - cnt) - cnt));
            map[wires[i][0] - 1][wires[i][1] - 1] = true;
            map[wires[i][1] - 1][wires[i][0] - 1] = true;
        }

        return answer;
    }

    public static void dfs(int next, int n) {

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[next][i]) {
                visited[i] = true;
                cnt++;
                dfs(i , n);
            }
        }
    }
}