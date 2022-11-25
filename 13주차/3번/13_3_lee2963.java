import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>();
        int end = 10;

        for (int i = 0; i < 10; i++) {
            setDiscount(discount[i]);
        }
        answer += checkJoin(want, number);

        for (int i = 0; i < discount.length - 10; i++) {
            map.put(discount[i], map.get(discount[i]) - 1);

            setDiscount(discount[end]);

            answer += checkJoin(want, number);
            end++;
        }

        return answer;
    }

    public void setDiscount(String product) {
        if (map.containsKey(product)) {
            map.put(product, map.get(product) + 1);
        } else{
            map.put(product, 1);
        }
    }

    public int checkJoin(String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if(!map.containsKey(want[i])){
                return 0;
            } else if(map.get(want[i]) != number[i]){
                return 0;
            }
        }
        return 1;
    }
}