1import java.util.ArrayList;

public class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {


        ArrayList<Integer> list = new ArrayList<>();
        int day = 0;
        int count = 1;
        boolean chk = false;

        for(int i = 0; i < progresses.length; i++){

            if (progresses[i] + (speeds[i] * day) >= 100) {

                chk = false;
                count++;
                continue;
            } else if (i != 0) {
                chk = true;
                list.add(count);
                count = 1;
            }

            int num = 100 - (progresses[i] +( speeds[i] * day));
            day += num / speeds[i];

            if(num % speeds[i] != 0){
                day += 1;
            }
        }

        list.add(count);

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        list.forEach(System.out::println);

        return answer;

    }
}