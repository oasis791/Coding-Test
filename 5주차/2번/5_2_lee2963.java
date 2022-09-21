import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();

        char pre = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);
        char now;
        int index = 1;

        for (int i = 1; i < words.length; i++) {
            now = words[i].charAt(0);

            if (now != pre || set.contains(words[i])) {
                return new int[]{(index % n) + 1, (index / n) + 1};
            } else {
                pre = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);
                index++;
            }
        }

        return new int[] {0, 0};
    }
}