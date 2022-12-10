import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int solution(int[] arrayA, int[] arrayB) {

        int a = func(arrayA, arrayB);
        int b = func(arrayB, arrayA);

        return Math.max(a, b);
    }

    public static int func(int[] a, int[] b) {
        int min = Integer.MAX_VALUE;

        for (int num : a) {
            min = Math.min(num, min);
        }

        List<Integer> divisor = getDivisor(min);


        for (Integer i : divisor) {
            boolean chk = true;

            for (int num : a) {
                if (num % i != 0) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                if (check(b, i)) {
                    return i;
                }
            }
        }

        return 0;
    }

    public static List<Integer> getDivisor(int min) {

        List<Integer> divisor = new ArrayList<>();

        for (int i = min; i >= 1; i--) {
            if (min % i == 0) {
                divisor.add(i);
            }
        }

        return divisor;
    }

    public static boolean check(int[] arrayB, int num) {

        for (int i : arrayB) {
            if (i % num == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {10, 10};
        int[] b = {11, 11};

        solution(a, b);

    }
}