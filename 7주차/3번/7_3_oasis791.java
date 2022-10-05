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
        Set<String> set = new LinkedHashSet<>();
        for (ArrayList<String> elements : list) {
            set.addAll(elements);
        }

        return set.stream().mapToInt(Integer::parseInt).toArray();
    }
}
