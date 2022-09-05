import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        Arrays.fill(answer, 1);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        if (func(j, k, i, places) == 0){
                            answer[i] = 0;
                            break;
                        }
                    }
                    if(answer[i] == 0) break;
                }
                if(answer[i] == 0) break;
            }
        }

        return answer;
    }

    public static int func(int x, int y, int z, String[][] places) {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        int[] nextX = {0, 1, 0, -1};
        int[] nextY = {1, 0, -1, 0};

        visited[x][y] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = cur[0] + nextX[i];
                int ny = cur[1] + nextY[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if(!visited[nx][ny]) {
                        if (places[z][nx].charAt(ny) == 'P') {
                            System.out.println("z = " + z +" x = "+  cur[0] +" y = " + cur[1] );
                            return 0;
                        } else if (places[z][nx].charAt(ny) == 'O' && cur[2] < 1) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny, cur[2] + 1});
                        }
                    }
                }
            }
        }
        return 1;
    }
}