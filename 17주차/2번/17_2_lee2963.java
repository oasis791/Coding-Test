import java.util.*;

class Solution {
    static boolean[] visited;
    static List<List<Integer>> candidateKeys;
    public static int solution(String[][] relation) {
        candidateKeys = new LinkedList<>();
        visited = new boolean[relation[0].length];

        for (int i = 0; i < relation[0].length; i++) {
            visited[i] = true;
            dfs(relation, i);
            visited[i] = false;
        }

        Collections.sort(candidateKeys, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        for (int i = 0; i < candidateKeys.size(); i++) {
            for (int j = i + 1; j < candidateKeys.size(); j++) {
                if (candidateKeys.get(j).containsAll(candidateKeys.get(i))) {
                    candidateKeys.remove(j);
                    j--;
                }
            }
        }

        return candidateKeys.size();
    }

    public static void dfs(String[][] relation, int cur){

        Set<String> set = new HashSet<>();
        List<Integer> index = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < visited.length; i++) {
            if(visited[i]){
                index.add(i);
            }
        }

        for (int i = 0; i < relation.length; i++) {
            String key = "";
            for (int j = 0; j < index.size(); j++) {
                key += j + relation[i][index.get(j)];
            }

            if (!set.contains(key)) {
                set.add(key);
                cnt++;
            } else{
                for (int j = cur + 1; j < visited.length; j++) {
                    if(!visited[j]){
                        visited[j] = true;
                        dfs(relation, j);
                        visited[j] = false;
                    }
                }
                return;
            }
        }

        if (cnt == relation.length) {
            Collections.sort(index);
            if (!candidateKeys.contains(index)) {
                candidateKeys.add(index);
            }
        }
    }
}