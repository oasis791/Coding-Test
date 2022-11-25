import java.util.Arrays;

class Solution {
    public static int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);

        for (int i = citations[len - 1]; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (citations[j] >= i) {
                    if (i > j - 1 && i <= len - j) {
                        System.out.println(i);
                        return i;
                    }
                }
            }
        }

        return answer;
    }
}