import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            if (cache.contains(cities[i].toLowerCase())) {
                cache.remove(cities[i].toLowerCase());
                if (cache.size() < cacheSize)
                    cache.add(cities[i].toLowerCase());
                answer += 1;
            } else {
                answer += 5;
                if(!cache.isEmpty() && cache.size() == cacheSize)
                    cache.remove(0);
                if (cache.size() < cacheSize)
                    cache.add(cities[i].toLowerCase());
            }
        }

        return answer;
    }
}