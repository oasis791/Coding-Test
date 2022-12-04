import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> seq = new HashMap<>();

        for (int i = 0; i < skill.length(); i++) {
            seq.put(skill.charAt(i), i);
        }

        int lastIndex = skill.length();
        for (String skillTree : skill_trees) {
            int curIndex = 0;
            boolean chk = true;
            for (int i = 0; i < skillTree.length(); i++) {
                char target = skillTree.charAt(i);
                if(seq.containsKey(target)){
                    if(curIndex < seq.get(target)){
                        chk = false;
                        break;
                    } else if( curIndex == seq.get(target)){
                        curIndex++;
                    }
                }
                if(curIndex == lastIndex)
                    break;
            }
            if(chk)
                answer++;
        }
        return answer;
    }
}