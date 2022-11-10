class Solution {
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while (true) {

            if(!compareAB(a, b)){
                return answer;
            }

            a = calculateNextNum(a);
            b = calculateNextNum(b);

            answer++;
        }
    }

    public int calculateNextNum(int target) {
        if(target % 2 == 0){
            return target / 2;
        }
        return (target / 2) + 1;
    }

    public boolean compareAB(int a, int b) {
        if (Math.abs(a - b) == 1) {
            return a / 2 == b / 2;
        }
        return true;
    }
}