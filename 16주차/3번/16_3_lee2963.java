class Solution {
    static int[] answer;
    public static int[] solution(int[][] arr) {
        answer = new int[2];
        int size = arr.length;

        dac(arr, 0, size - 1, 0, size - 1, size);

        return answer;
    }

    public static void dac(int[][] arr, int startX, int endX, int startY, int endY, int size) {
        int chk = arr[startX][startY];

        if (size >= 2 ) {
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (arr[i][j] != chk) {
                        int nextSize = size / 2;
                        dac(arr, startX, startX + nextSize -1, startY, startY + nextSize - 1, nextSize);
                        dac(arr, startX, startX + nextSize -1, startY + nextSize, endY, nextSize);
                        dac(arr, startX + nextSize, endX, startY, startY + nextSize -1, nextSize);
                        dac(arr, startX + nextSize, endX, startY + nextSize, endY, nextSize);
                        return;
                    }
                }
            }
        }
        answer[chk] += 1;
    }
}