import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int size : tangerine) {
            if (map.containsKey(size)) {
                map.put(size, map.get(size) + 1);
            } else{
                map.put(size, 1);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));

        for (Integer size : keySet) {
            k -= map.get(size);
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}