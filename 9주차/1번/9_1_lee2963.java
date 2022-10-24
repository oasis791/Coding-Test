
public class Solution {
    public static int solution(int n) {
        int answer = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else{
                n -= 1;
                answer++;
            }
        }

        return answer;
    }
}