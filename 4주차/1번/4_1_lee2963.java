
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder(s);
        int cnt = 0;

        for (int i = 0; i < sb.length(); i++) {
            cnt++;
            if (sb.charAt(i) == ' ') {
                cnt = 0;
                continue;
            } else{
                if (cnt % 2 != 0) {
                    sb.replace(i, i + 1, s.substring(i,i+1).toUpperCase());
                } else{
                    sb.replace(i, i + 1, s.substring(i,i+1).toLowerCase());
                }
            }

        }

        answer = sb.toString();
        return answer;
    }
}