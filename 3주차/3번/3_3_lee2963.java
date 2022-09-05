import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else{
                map.put(nums[i], 1);
            }
        }

        int size = map.size();

        if (size >= len / 2) {
            answer = len / 2;
        } else {
            answer = size;
        }

        return answer;
    }
}