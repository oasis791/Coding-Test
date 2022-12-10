import java.util.Arrays;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        todo: for (int i = arrayA[arrayA.length - 1]; i >= 1; i--) {
            for (int j = 0; j < arrayA.length; j++) {
                if (arrayA[j] % i != 0) {
                    continue todo;
                }
            }

            for (int j = 0; j < arrayB.length; j++) {
                if (arrayB[j] % i == 0)
                    continue todo;
            }
            answer = Math.max(answer, i);
        }

        todo2: for (int i = arrayB[arrayB.length - 1]; i >= 1; i--) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayB[j] % i != 0) {
                    continue todo2;
                }
            }

            for (int j = 0; j < arrayA.length; j++) {
                if (arrayA[j] % i == 0)
                    continue todo2;
            }
            answer = Math.max(answer, i);
        }

        return answer;
    }
}
