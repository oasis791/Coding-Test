import java.util.*;

class Solution {

  public int solution(int k, int[] tangerine) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int j : tangerine) {
      if (map.containsKey(j)) {
        map.put(j, map.get(j) + 1);
      } else {
        map.put(j, 1);
      }
    }
    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(
      map.entrySet()
    );
    entryList.sort(Map.Entry.comparingByValue((o1, o2) -> o2 - o1));

    int answer = 0;
    for (int i = 0; i < entryList.size(); i++) {
      k -= entryList.get(i).getValue();
      if (k <= 0) {
        answer = i + 1;
        break;
      }
    }
    return answer;
  }
}
