class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder("");
        int[] newNum = {4, 1, 2};

        while ( n > 0) {
            sb.append(newNum[n % 3]);

            if (n % 3 == 0) {
                n = (n / 3) - 1;
            } else{
                n /= 3;
            }
        }

        sb.reverse();
        return sb.toString();
    }
}