import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int person = 1;
        int round = 1;

        for (int i = 1; i < words.length; i++) {
            if (person == n) {
                person = 0;
                round++;
            }
            person++;
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return new int[] { person, round };
            } else if (set.contains(words[i])) {
                return new int[] { person, round };
            } else {
                set.add(words[i]);
            }
        }
        return new int[] { 0, 0 };
    }
}