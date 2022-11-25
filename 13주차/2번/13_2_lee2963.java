import java.util.*;

class Solution {
    static HashMap<String, Integer>[] candidateMenu;
    static boolean[] visited;
    public static List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        candidateMenu = new HashMap[course.length];

        for (int i = 0; i < course.length; i++) {
            candidateMenu[i] = new HashMap<>();
        }

        for (int i = 0; i < orders.length; i++) {
            visited = new boolean[orders[i].length()];
            String[] order = orders[i].split("");
            Arrays.sort(order);

            for (int j = 0; j < course.length; j++) {
                for (int k = 0; k < order.length; k++) {
                    dfs(order, course[j], 1, k, j, order[k]);
                }
            }
        }

        for (HashMap<String, Integer> menu : candidateMenu) {
            List<String> candidate = new ArrayList<>();
            int max = 0;
            for (Map.Entry<String, Integer> entry : menu.entrySet()) {
                if(entry.getValue() > 1) {
                    if (max < entry.getValue()) {
                        max = entry.getValue();
                        candidate.clear();
                        candidate.add(entry.getKey());
                    } else if (max == entry.getValue()) {
                        candidate.add(entry.getKey());
                    }
                }
            }

            answer.addAll(candidate);
        }
        Collections.sort(answer);

        return answer;
    }

    public static void dfs(String[] order, int size, int cnt, int index, int courseIndex, String cur) {
        if (cnt == size) {
            if (candidateMenu[courseIndex].containsKey(cur)) {
                candidateMenu[courseIndex].put(cur, candidateMenu[courseIndex].get(cur) + 1);
            } else {
                candidateMenu[courseIndex].put(cur, 1);
            }
            return;
        }

        for (int i = index + 1; i < order.length; i++) {
            dfs(order, size, cnt + 1, i, courseIndex, cur + order[i]);
        }

    }
}