import java.util.Arrays;

class Solution {
    public  String solution(int[] numbers) {
        String answer = "";
        String[] newNumbers = new String[numbers.length];
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < numbers.length; i++){
            newNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(newNumbers , (o1, o2) -> {
            String caseFirst = o1.concat(o2);
            String caseSecond = o2.concat(o1);

            if (caseFirst.compareTo(caseSecond) == 0) {
                return 0;
            } else if (caseFirst.compareTo(caseSecond) < 0) {
                return 1;
            } else{
                return -1;
            }
        });

        if (newNumbers[0].equals("0")) {
            answer = "0";
        }
        else {
            for (int i = 0; i < newNumbers.length; i++) {
                result.append(newNumbers[i]);
            }

            answer = result.toString();
        }

        return answer;
    }
}