import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  public int solution(int[] queue1, int[] queue2) {
    int sum = queue1.length + queue2.length;
    if (sum % 2 != 0) return -1;

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    Arrays.stream(queue1).forEach(q1::offer);
    Arrays.stream(queue2).forEach(q2::offer);

    int count = 0;
    long sum1 = q1.stream().mapToInt(i -> i).sum();
    long sum2 = q2.stream().mapToInt(i -> i).sum();

    for (int i = 0; i < (q1.size() + q2.size()) * 2; i++) {
      if (sum1 > sum2) {
        sum1 -= q1.peek();
        sum2 += q1.peek();
        q2.offer(q1.poll());
        count++;
      } else if (sum1 < sum2) {
        sum1 += q2.peek();
        sum2 -= q2.peek();
        q1.offer(q2.poll());
        count++;
      } else {
        return count;
      }
    }
    return -1;
  }
}
