import java.util.HashMap;

class Solution {
    HashMap<Character, Integer> map;
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder("");
        map = new HashMap<>();
        char first;
        char second;
        int score;

        for (int i = 0; i < survey.length; i++) {
            first = survey[i].charAt(0);
            second = survey[i].charAt(1);
            if (choices[i] < 4) {
                score = 4 - choices[i];
                if (map.containsKey(first)) {
                    map.put(first, map.get(first) + score);
                } else{
                    map.put(first, score);
                    map.put(second, 0);
                }
            } else if (choices[i] > 4) {
                score = choices[i] - 4;
                if (map.containsKey(second)) {
                    map.put(second, map.get(second) + score);
                } else{
                    map.put(first, 0);
                    map.put(second, score);
                }
            }
        }

        answer.append(makeMBTI('R', 'T'));
        answer.append(makeMBTI('C', 'F'));
        answer.append(makeMBTI('J', 'M'));
        answer.append(makeMBTI('A', 'N'));
        System.out.println(answer);
        return answer.toString();
    }

    public String makeMBTI(Character first, Character second) {
        if (map.containsKey(first)) {
            if (map.get(first) >= map.get(second)) {
                return first.toString();
            } else {
                return second.toString();
            }
        }

        return first.toString();
    }
}