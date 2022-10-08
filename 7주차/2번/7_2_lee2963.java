import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int index = 1;

        for (int i = 65; i <= 90; i++) {
            char ch = (char) i;
            map.put(String.valueOf(ch), index);
            index++;
        }

        int start = 0;
        int end = start + 2;
        while (end <= msg.length()) {
            String target = msg.substring(start, end);
            if (map.containsKey(target)) {
                end++;
            } else {
                map.put(target, index);
                index++;
                answer.add(map.get(msg.substring(start, end - 1)));
                start = end - 1;
                end = start + 2;
            }
        }

        answer.add(map.get(msg.substring(start, msg.length())));

        return answer;
    }
}