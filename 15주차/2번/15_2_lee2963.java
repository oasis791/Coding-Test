class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (long i = 0; i <= d / k; i++) {
            double y = Math.sqrt((long) d * d - ((i * k) * (i * k)));
            answer += (long) (y / k) + 1;

        }
        return answer;
    }
}