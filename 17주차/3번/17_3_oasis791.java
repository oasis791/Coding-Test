import java.util.*;

class Solution {

  public int solution(int n, int[][] wires) {
    ArrayList<Integer>[] list = new ArrayList[n + 1];
    int answer = Integer.MAX_VALUE;
    int count = 0;
    for (int[] wire : wires) {
      if (list[wire[0]] == null) list[wire[0]] = new ArrayList<>();
      if (list[wire[1]] == null) list[wire[1]] = new ArrayList<>();
      list[wire[0]].add(wire[1]);
      list[wire[1]].add(wire[0]);
    }

    for (int[] wire : wires) {
      count = 0;
      boolean[] visited = new boolean[n + 1];
      Queue<Integer> queue = new LinkedList<>();
      queue.add(wire[0]);
      visited[wire[1]] = true;

      while (!queue.isEmpty()) {
        Integer target = queue.poll();
        visited[target] = true;
        count++;
        for (int i = 0; i < list[target].size(); i++) {
          if (!visited[list[target].get(i)]) queue.offer(list[target].get(i));
        }
      }
      answer = Math.min(Math.abs((n - count) - count), answer);
    }
    return answer;
  }
}
