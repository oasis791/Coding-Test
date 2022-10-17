class Solution {
    public int solution(String dartResult) {
        StringBuilder num = new StringBuilder();
        int answer = 0;
        int now = 0;
        int prev = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case 'S':
                    prev = now;
                    now = Integer.parseInt(num.toString());
                    answer += now;
                    num.delete(0, num.length());
                    break;
                case 'D':
                    prev = now;
                    now = (int) Math.pow(Integer.parseInt(num.toString()), 2);
                    answer += now;
                    num.delete(0, num.length());
                    break;
                case 'T':
                    prev = now;
                    now = (int) Math.pow(Integer.parseInt(num.toString()), 3);
                    answer += now;
                    num.delete(0, num.length());
                    break;
                case '#':
                    now *= -1;
                    answer += 2 * now;
                    break;
                case '*':
                    answer = answer + prev + now;
                    now *= 2;
                    break;
                default:
                    num.append(dartResult.charAt(i));
                    break;
            }
        }
        return answer;
    }
}
