class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        int a;
        int b;
        int r;

        for (int i = 1; i < arr.length ; i ++) {
            a = answer;
            b = arr[i];
            while (b != 0) {
                r = a % b;
                a = b;
                b = r;
            }
            answer = (answer * arr[i]) / a;
        }
        System.out.println(answer);
        return answer;
    }
}