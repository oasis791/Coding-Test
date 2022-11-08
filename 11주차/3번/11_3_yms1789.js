function solution(n) {
  let answer;
  function fibo(n) {
    if (n <= 1) {
      return 1;
    }
    let goMethod = [0, 1, 2, ...Array(n - 2).fill(0)];
    for (let i = 3; i < goMethod.length; i++) {
      goMethod[i] = (goMethod[i - 1] + goMethod[i - 2]) % 1234567;
    }
    return goMethod;
  }
  answer = fibo(n);
  if (n === 1) {
    return answer % 1234567;
  } else {
    return answer[n] % 1234567;
  }
}
