class Solution {
    static int answer;

    public int solution(int[] number) {
        answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            boolean[] visited = new boolean[number.length];
            visited[i] = true;
            dfs(number, visited, 1, number[i], i);
        }
        return answer;
    }

    public static void dfs(int[] number, boolean[] visited, int depth, int count, int index) {
        if (depth == 3) {
            if (count == 0)
                answer++;
            return;
        }

        for (; index < number.length; index++) {
            if (!visited[index]) {
                visited[index] = true;
                dfs(number, visited, depth + 1, count + number[index], index);
                visited[index] = false;
            }
        }
    }
}
