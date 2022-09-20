import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[][] cost = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if (cost[row][col] != 0) {
                cost[row][col] = Math.min(cost[row][col], val);
            } else{
                cost[row][col] = val;
            }
        }

        for (int round = 1; round <= n; round++) {
            for (int i = 1; i <= n; i++) {
                if (i != round) {
                    int roundCost = cost[i][round];
                    if(roundCost == 0)
                        continue;
                    for (int j = 1; j <= n; j++) {
                        if (i != j && j != round) {
                            if(cost[round][j]!=0) {
                                if (cost[i][j] == 0 || cost[i][j] > roundCost + cost[round][j]) {
                                    cost[i][j] = roundCost + cost[round][j];
                                }
                            }
                        }
                    }
                }
            }
        }

        //answer
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(cost[i][j] + " ");
            System.out.println();
        }
    }
}
