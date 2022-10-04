class Solution {

  public int solution(int[] arr) {
    int target = lcm(arr[0], arr[1]);
    if (arr.length >= 3) {
      for (int i = 2; i < arr.length; i++) {
        target = lcm(target, arr[i]);
      }
    }
    return target;
  }

  static int lcm(int n, int m) {
    int a = n, b = m, r;
    while (b != 0) {
      r = a % b;
      a = b;
      b = r;
    }
    int gcd = a;

    return (n * m) / gcd;
  }
}
