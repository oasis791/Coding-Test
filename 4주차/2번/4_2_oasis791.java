class Solution {

  public int[] solution(int brown, int yellow) {
    double sqrt = Math.sqrt(yellow);
    for (int i = 1; i <= sqrt; i++) {
      if (yellow % i == 0) {
        if ((2 * (yellow / i) + 2 * i) + 4 == brown) {
          return new int[] { yellow / i + 2, i + 2 };
        }
      }
    }
    return new int[] {};
  }
}
