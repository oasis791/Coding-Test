import java.util.Arrays;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        for (int i = 0; i < cards.length; i++) {
            int first = 0;
            int second = 0;
            boolean[] visited = new boolean[cards.length];
            first = play(cards, i, visited);
            for (int j = 0; j < cards.length; j++) {
                boolean[] copiedVisited = Arrays.copyOf(visited, visited.length);
                second = play(cards, j, copiedVisited);
                answer = Math.max(answer, first * second);
            }
        }
        return answer;
    }

    static int play(int[] cards, int index, boolean[] visited) {
        int count = 0;
        while (true) {
            if (!visited[index]) {
                visited[index] = true;
                count++;
                index = cards[index] - 1;
            } else {
                break;
            }
        }
        return count;
    }
}
