import java.util.HashSet;
import java.util.Set;

class Solution {

    static Set<Integer> set;
    static boolean[] prime = new boolean[10000001];

    public int solution(String numbers) {
        set = new HashSet<>();
        isPrime();
        int[] num = new int[numbers.length()];
        String[] stringNumber = numbers.split("");
        for (int i = 0; i < numbers.length(); i++) {
            num[i] = Integer.parseInt(stringNumber[i]);
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0)
                continue;
            boolean[] visited = new boolean[num.length];
            StringBuilder sb = new StringBuilder();
            visited[i] = true;
            sb.append(num[i]);
            dfs(sb, visited, num);
        }
        return set.size();
    }

    static void dfs(StringBuilder sb, boolean[] visited, int[] num) {
        if (!prime[Integer.parseInt(sb.toString())]) {
            set.add(Integer.parseInt(sb.toString()));
        }

        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(num[i]);
                dfs(sb, visited, num);
                visited[i] = false;
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }

    static void isPrime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i < 10000000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 10000000; j += i)
                    prime[j] = true;
            }
        }
    }
}
