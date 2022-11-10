class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int emptyCoke = n;
        int notEmptyCoke = 0;

        while (emptyCoke >= a) {
            notEmptyCoke = (emptyCoke / a) * b;
            emptyCoke = emptyCoke % a;

            answer += notEmptyCoke;
            emptyCoke +=  notEmptyCoke;
        }

        return answer;
    }
}
