import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int sameNum = 0;
        int zeroNum = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int lottoIndex = lottos.length - 1;
        int winIndex = win_nums.length - 1;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) zeroNum++;
            else break;
        }

        while (lottoIndex >= zeroNum && winIndex >= 0) {

            if (lottos[lottoIndex] > win_nums[winIndex]) {
                lottoIndex--;
            } else if (lottos[lottoIndex] < win_nums[winIndex]) {
                winIndex--;
            } else{
                sameNum++;
                lottoIndex--;
                winIndex--;
            }
        }


        return new int[]{rank[sameNum + zeroNum], rank[sameNum]};
    }
}