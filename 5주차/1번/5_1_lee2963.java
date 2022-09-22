import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int person = Integer.parseInt(br.readLine());
            int[] rank = new int[person + 1];

            for (int j = 0; j < person; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int doc = Integer.parseInt(st.nextToken());
                int inter = Integer.parseInt(st.nextToken());

                rank[doc] = inter;
            }

            int minRank = rank[1];
            int result = 1;

            for (int j = 2; j <= person ; j++) {
                if (minRank > rank[j]) {
                    minRank = rank[j];
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}