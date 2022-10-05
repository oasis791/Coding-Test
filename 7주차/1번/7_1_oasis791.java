import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> win = new HashSet<>();
        Arrays.stream(win_nums).forEach(win::add);

        int best = 0;
        int worst = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (win.contains(lottos[i])) {
                best++;
                worst++;
            }
            if (lottos[i] == 0)
                best++;
        }
        return new int[] { rank(best), rank(worst) };
    }

    static int rank(int input) {
        switch (input) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
