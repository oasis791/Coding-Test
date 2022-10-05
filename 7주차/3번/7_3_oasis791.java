import java.util.*;

class Solution {
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "{");
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String s1 = st.nextToken();
            s1 = s1.replaceAll("[{}]", "");
            StringTokenizer st2 = new StringTokenizer(s1, ",");
            ArrayList<String> temp = new ArrayList<>();
            while (st2.hasMoreTokens()) {
                temp.add(st2.nextToken());
            }
            list.add(temp);
        }

        Comparator<ArrayList<String>> comparator = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.size() - o2.size();
            }
        };

        Collections.sort(list, comparator);

        List<String> answer = new ArrayList<>();
        String prev = list.get(0).get(0);
        answer.add(prev);
        for (int i = 1; i < list.size(); i++) {
            for (int k = i; k < list.size(); k++) {
                for (int j = 0; j < list.get(k).size(); j++) {
                    if (prev.equals(list.get(k).get(j))) {
                        list.get(k).remove(j);
                        break;
                    }
                }
            }
            answer.add(list.get(i).get(0));
            prev = list.get(i).get(0);
        }
        return answer.stream().mapToInt(Integer::parseInt).toArray();
    }
}
