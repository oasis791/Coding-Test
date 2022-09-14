
class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int col;
        int row;

        for (int i = 1; 1 <= yellow / 2; i++) {

            if (yellow % i == 0) {
                if ((((yellow / i) + 1) + (i + 1)) * 2 == brown) {
                    answer[0] = yellow / i;
                    answer[1] = i;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        solution(brown, yellow);
    }
}