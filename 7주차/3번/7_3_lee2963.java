import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        String[] arr = s.split("},");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("{", "");
            arr[i] = arr[i].replace("}", "");
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        set.add(arr[0]);
        answer.add(Integer.parseInt(arr[0]));

        for (int i = 1; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(arr[i], ",");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                if (!set.contains(token)) {
                    set.add(token);
                    answer.add(Integer.parseInt(token));
                }
            }
        }

        return answer;
    }
}