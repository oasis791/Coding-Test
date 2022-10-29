class Solution {
    public int solution(int n) {
        int answer = 0;
        int oneCnt = Integer.bitCount(n);

        while (true) {
            n++;

            int cnt = Integer.bitCount(n);

            if (oneCnt == cnt) {
                answer = n;
                break;
            }

        }
        return answer;
    }
}