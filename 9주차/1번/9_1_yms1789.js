function solution(n) {
  let ans = 0;
  while (n >= 1) {
    if (n % 2 !== 0) {
      ans++;
      n -= 1;
    } else {
      n = Math.floor(n / 2);
    }
  }
  return ans;
}
