class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int[] arr = new int[queue1.length * 2];
        long sumQ1 = 0;
        long sumQ2 = 0;
        int point1 = 0;
        int point2 = queue1.length;

        for (int i = 0; i < queue1.length * 2; i++) {
            if (i < queue1.length) {
                arr[i] = queue1[i];
                sumQ1 += queue1[i];
            } else{
                arr[i] = queue2[i - queue2.length];
                sumQ2 += queue2[i - queue2.length];
            }
        }

        while (true) {


            if (point1 == arr.length - 1 || point2 == queue1.length - 1) {
                return -1;
            }

            if (sumQ1 > sumQ2) {
                sumQ1 -= arr[point1];
                sumQ2 += arr[point1];

                point1++;
            } else if (sumQ1 < sumQ2) {
                sumQ1 += arr[point2];
                sumQ2 -= arr[point2];

                if (point2 == arr.length - 1) {
                    point2 = 0;
                } else{
                    point2++;
                }

            }
            else{
                break;
            }
            answer++;
        }
        System.out.println(answer);
        return answer;
    }

}