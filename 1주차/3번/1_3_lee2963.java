import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];

            int[] arr = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(arr);

            answer[i] = arr[num - 1];
        }

        return answer;
    }
}