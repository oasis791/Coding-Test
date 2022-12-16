import java.util.ArrayList;
import java.util.List;

class Solution {
    static int[][] map;

    public static int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        map = new int[n][n];
        goDown(0, 0, 1, n, 0);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer.add(map[i][j]);
            }

        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void goDown(int x, int y, int index, int n, int cnt) {
        if (cnt == n) {
            return;
        }
        int i;
        for (i = 0; i < n; i++) {
            if (x + i < n && map[x + i][y] == 0) {
                map[x + i][y] = index;
                index++;
            } else {
                break;
            }
        }
        goRight(x + i - 1, y + 1, index, n, cnt + 1);
    }

    public static void goRight(int x, int y, int index, int n, int cnt) {
        if (cnt == n) {
            return;
        }
        int i;
        for (i = 0; i < n; i++) {
            if (y + i < n && map[x][y + i] == 0) {
                map[x][y + i] = index;
                index++;
            } else {
                break;
            }
        }
        goUp(x - 1, y + i - 2, index, n, cnt + 1);
    }

    public static void goUp(int x, int y, int index, int n, int cnt) {
        if (cnt == n) {
            return;
        }
        int i;

        for (i = 0; i < n; i++) {
            if (x - i >= 0 && y - i >= 0 && map[x - i][y - i] == 0) {
                map[x - i][y - i] = index;
                index++;
            } else {
                break;
            }
        }

        goDown(x - i + 2, y - i + 1, index, n, cnt + 1);

    }
}
