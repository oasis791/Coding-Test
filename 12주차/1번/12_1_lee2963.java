import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> combineNum;
    boolean[] visited;
    public int solution(String numbers) {
        combineNum = new HashSet<>();
        String[] spiltNumber = spiltNumber(numbers);
        visited = new boolean[numbers.length()];

        for (int i = 1; i <= spiltNumber.length; i++) {
            for (int j = 0; j < spiltNumber.length; j++) {
                int cur = Integer.parseInt(spiltNumber[j]);

                visited[j] = true;
                func(1, i, cur, spiltNumber);
                visited[j] = false;
            }
        }

        return chkPrimeNum();
    }

    public String[] spiltNumber(String numbers) {
        return numbers.split("");
    }

    public void func(int cnt, int max, int result, String[] spiltNumber){
        if (cnt == max) {
            combineNum.add(result);
            return;
        }

        for (int i = 0; i < spiltNumber.length; i++) {
            if(!visited[i]) {
                result *= 10;
                result += Integer.parseInt(spiltNumber[i]);
                visited[i] = true;
                func(cnt + 1, max, result, spiltNumber);
                result -= Integer.parseInt(spiltNumber[i]);
                result /= 10;
                visited[i] = false;
            }
        }
    }

    public int chkPrimeNum() {
        int answer = 0;

        for (Integer integer : combineNum) {
            boolean chk = false;
            for (int i = 2; i <= integer / 2; i++) {
                if(integer % i ==0){
                    chk = true;
                    break;
                }
            }
            if(!chk && integer != 1 && integer != 0){
                answer++;
            }

        }
        return answer;
    }
}