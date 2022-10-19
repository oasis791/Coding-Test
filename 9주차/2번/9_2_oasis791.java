class Solution {

    public int solution(int k, int[][] dungeons) {
        return dfs(k, dungeons, new boolean[dungeons.length], 0, 0);
    }

    public static int dfs(int fatigue, int[][] dungeons, boolean[] visited, int count, int answer) {
        if (fatigue > 0) {
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && fatigue >= dungeons[i][0]) {
                    visited[i] = true;
                    answer = dfs(fatigue - dungeons[i][1], dungeons, visited, count + 1, answer);
                    visited[i] = false;
                }
            }
        }
        answer = Math.max(count, answer);
        return answer;
    }
}
