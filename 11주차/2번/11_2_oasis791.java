import java.util.ArrayList;

class Solution {

  public int[] solution(int n, long k) {
    ArrayList<Integer> elements = new ArrayList<>();
    int[] result = new int[n];
    int index = 0;
    long target = 1;
    for (int i = 1; i <= n; i++) {
      target *= i;
      elements.add(i);
    }

    while (elements.size() != 0) {
      target /= elements.size();
      long quotient = k / target;
      long remainder = k % target;

      if (remainder == 0) {
        quotient = (quotient - 1 == -1) ? elements.size() - 1 : quotient - 1;
      }

      result[index++] = elements.get((int) quotient);
      elements.remove((int) quotient);
      k = remainder;
    }

    return result;
  }
}
