import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int[] move_row = new int[] { -1, 0, 1, 0 };
        int[] move_col = new int[] { 0, 1, 0, -1 };

        for (int place = 0; place < places.length; place++) {
            String[][] room = new String[5][5];
            ArrayList<int[]> p_point = new ArrayList<>();

            for (int i = 0; i < places.length; i++) {
                String[] split = places[place][i].split("");
                for (int j = 0; j < split.length; j++) {
                    if (split[j].equals("P"))
                        p_point.add(new int[] { i, j });
                    room[i][j] = split[j];
                }
            }

            boolean isStopped = false;
            target: for (int[] point : p_point) {
                int[][] dist = new int[5][5];
                Queue<int[]> queue = new LinkedList<>();
                dist[point[0]][point[1]] = -1;
                queue.offer(point);

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int row = cur[0];
                    int col = cur[1];

                    if (room[row][col].equals("P") && dist[row][col] != -1) {
                        if (dist[row][col] <= 2) {
                            isStopped = true;
                            break target;
                        }
                    }

                    if (dist[row][col] == 2)
                        continue;

                    for (int i = 0; i < 4; i++) {
                        int next_row = row + move_row[i];
                        int next_col = col + move_col[i];

                        if (next_row >= 0 && next_row < 5 && next_col >= 0 && next_col < 5
                                && !room[next_row][next_col].equals("X") && dist[next_row][next_col] == 0) {
                            if (dist[row][col] == -1) {
                                dist[next_row][next_col] = 1;
                            } else {
                                dist[next_row][next_col] = dist[row][col] + 1;
                            }
                            queue.offer(new int[] { next_row, next_col });
                        }
                    }
                }
            }
            if (!isStopped)
                answer[place] = 1;
        }
        return answer;
    }
}
