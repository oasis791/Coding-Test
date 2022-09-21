import java.util.Arrays;

class Solution {
    int[] answer = new int[11];
    int[] infoR = new int[11];
    int max = 0;
    public int[] solution(int n, int[] info) {

        for (int i = 0; i < 11; i++) {
            if(info[i] < n) {
                infoR[i] += info[i] + 1;
                n -= infoR[i];
                func(n, info, i + 1,  10 - i,0,1);
                n += infoR[i];
                infoR[i] -= (info[i] + 1);
            }
        }

        if (max == 0) {
            return new int[]{-1};
        } else {
            for (int i = 0; i < 11; i++) {
                System.out.print(answer[i] +" ");
            }
            return answer;
        }



    }

    public void func(int n, int[] info, int index, int rPoint, int last, int cnt) {
        if (n == 0 || cnt == 11) {
            int aPoint = 0;
            for (int i = 0; i < 11; i++) {
                if (info[i] > infoR[i]) {
                    aPoint += (10 - i);
                }
            }

            if(aPoint < rPoint) {
                if (max < rPoint - aPoint) {
                    answer = Arrays.copyOf(infoR, infoR.length);
                    answer[10] += n;
                    max = rPoint - aPoint;
                } else if (max == rPoint - aPoint) {
                    for (int i = 10; i >= 0; i--) {
                        if (answer[i] > infoR[i]) {
                            break;
                        } else if (answer[i] < infoR[i]) {
                            answer = Arrays.copyOf(infoR, infoR.length);
                            answer[10] += n;
                            max = rPoint - aPoint;
                            break;
                        }
                    }
                }
            }
            return;
        }

        for (int i = index; i < 11; i++) {
            if(info[i] < n) {
                infoR[i] += info[i] + 1;
                n -= infoR[i];
                last = i;
                func(n, info, i + 1, rPoint + (10 - i), last, cnt + 1);
                n += infoR[i];
                infoR[i] -= (info[i] + 1);
            }
            if (i == 10) {
                func(n, info, i + 1, rPoint , last, 11);
            }
        }
    }
}