class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int border;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                border = (((yellow / i) + 1) + (i + 1)) * 2;
                if ( border == brown) {
                    answer[0] = (yellow / i) + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }

        return answer;
    }
}