import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int t,n;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());

        for (int c = 0; c < t; c++) {
            int count = 1;
            n = Integer.parseInt(bf.readLine());
            int[] applicants = new int[n + 1];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                applicants[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int target = applicants[1];
            for (int i = 2; i <= n; i++) {
                if (target > applicants[i]) {
                    count++;
                    target = applicants[i];
                }
            }
            System.out.println(count);
        }
    }
}
