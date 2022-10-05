import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int index = 1;
        for (char i = 'A'; i <= 'Z'; i++)
            dictionary.put(String.valueOf(i), index++);

        String[] split = msg.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.delete(0, sb.length());
            int j = i;
            for (; j < split.length; j++) {
                sb.append(split[j]);
                if (!dictionary.containsKey(sb.toString())) {
                    dictionary.put(sb.toString(), index++);
                    list.add(dictionary.get(sb.deleteCharAt(sb.length() - 1).toString()));
                    i = j - 1;
                    break;
                }
            }
            if (j == split.length) {
                list.add(dictionary.get(sb.toString()));
                break;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
