import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return 5 * cities.length;
        Map<String, Integer> cache = new HashMap<>();
        int time = 0;
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if (cache.containsKey(city)) {
                cache.put(city, time++);
                answer += 1;
            } else {
                if (cache.size() < cacheSize) {
                    cache.put(city, time++);
                    answer += 5;
                    continue;
                }

                int min = Integer.MAX_VALUE;
                String keyName = null;
                for (String key : cache.keySet()) {
                    if (cache.get(key) < min) {
                        min = cache.get(key);
                        keyName = key;
                    }
                }
                cache.remove(keyName);
                cache.put(city, time++);
                answer += 5;
            }
        }
        return answer;
    }
}
