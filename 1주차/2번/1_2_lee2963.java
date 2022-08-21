import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {

        int[] nextX = {1, 0, -1, 0};
        int[] nextY = {0, 1, 0, -1};

        Queue<Integer> X = new LinkedList<>();
        Queue<Integer> Y = new LinkedList<>();

        X.add(0);
        Y.add(0);

        while (!X.isEmpty()) {

            int x = X.poll();
            int y = Y.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + nextX[i];
                int ny = y + nextY[i];

                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {
                    if (nx == maps.length - 1 && ny == maps[0].length - 1) {
                        return maps[x][y] + 1;
                    }
                    else if (maps[nx][ny] == 1) {
                        X.add(nx);
                        Y.add(ny);
                        maps[nx][ny] = maps[x][y] + 1;
                    }
                }
            }
        }

        return -1;
    }
}