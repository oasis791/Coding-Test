import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean chk = false;

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                chk = true;
                break;
            }
        }

        if (!chk) {
            answer = participant[participant.length - 1];
        }
        return answer;
    }
}