import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] select = new int[] { 0, 3, 2, 1, 0, 1, 2, 3 };
        HashMap<Character, Integer> indicator = new HashMap<>();
        indicator.put('R', 0);
        indicator.put('T', 0);
        indicator.put('C', 0);
        indicator.put('F', 0);
        indicator.put('J', 0);
        indicator.put('M', 0);
        indicator.put('A', 0);
        indicator.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] <= 3) {
                indicator.put(survey[i].charAt(0), indicator.get(survey[i].charAt(0)) + select[choices[i]]);
            } else {
                indicator.put(survey[i].charAt(1), indicator.get(survey[i].charAt(1)) + select[choices[i]]);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (indicator.get('R') >= indicator.get('T')) {
            sb.append('R');
        } else {
            sb.append('T');
        }
        if (indicator.get('C') >= indicator.get('F')) {
            sb.append('C');
        } else {
            sb.append('F');
        }
        if (indicator.get('J') >= indicator.get('M')) {
            sb.append('J');
        } else {
            sb.append('M');
        }
        if (indicator.get('A') >= indicator.get('N')) {
            sb.append('A');
        } else {
            sb.append('N');
        }

        return sb.toString();
    }
}
