import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;
        int boat = 0;

        Arrays.sort(people);

        for (int i = people.length - 1; i >= index; i--) {
            boat++;
            if (people[i] + people[index] <= limit) {
                index++;
            }
        }
        answer = boat;
        return answer;
    }
}