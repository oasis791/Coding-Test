class Solution {
    int max = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        for (int i = 0; i < dungeons.length; i++) {
            visited[i] = true;
            func(k - dungeons[i][1] , 1, dungeons);
            visited[i] = false;
        }
        return max;
    }

    public void func(int tired, int cnt, int[][] dungeons) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (tired >= dungeons[i][0]) {
                    tired -= dungeons[i][1];
                    visited[i] = true;
                    func(tired, cnt + 1, dungeons);
                    tired += dungeons[i][1];
                    visited[i] = false;
                }
            }
            max = Math.max(cnt, max);
        }
    }

}