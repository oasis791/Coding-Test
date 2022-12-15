class Solution {
    static boolean[] visited;
    static int[] result;

    public static int solution(int[] cards) {
        int answer = 1;
        result = new int[cards.length];
        visited = new boolean[cards.length];

        for (int i = 0; i < cards.length; i++) {
            if (!visited[cards[i] - 1]) {
                visited[i] = true;
                func(cards, cards[i] - 1, 1, i);
            }
        }

        for (int i = 0; i < 2; i++) {
            answer *= getMax(result);
        }

        return answer;
    }

    public static void func(int[] cards, int nextIndex, int cnt, int start) {

        if (visited[nextIndex]) {
            result[start] = cnt;
        } else {
            visited[nextIndex] = true;
            func(cards, cards[nextIndex] - 1, cnt + 1, start);
        }
    }

    public static int getMax(int[] result) {
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];
                index = i;
            }
        }
        result[index] = 0;

        return max;
    }
}