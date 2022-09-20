import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        int[][] dist = new int[city + 1][city + 1];
        int INF = Integer.MAX_VALUE / 2;

        for (int i = 0; i <= city ; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[start][end] = Math.min(dist[start][end],cost);
        }

        for (int k = 1; k <= city; k++) {
            for (int i = 1; i <= city; i++) {
                for (int j = 1; j <= city; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                if(dist[i][j] != INF) {
                    System.out.print(dist[i][j] + " ");
                } else{
                    System.out.print(0 +" ");
                }
            }
            System.out.println();
        }

    }
}
