function solution(n, k) {
  let answer = [];
  let lineUp = Array(n)
    .fill()
    .map((_, idx) => idx + 1);
  let order = k - 1;
  const factorial = (n) => {
    let res = 1;
    for (let i = 2; i <= n; i++) {
      res *= i;
    }
    return res;
  };
  while (lineUp.length) {
    if (order === 0) {
      answer.push(...lineUp);
      break;
    }
    const fact = factorial(lineUp.length - 1); // 줄 세울 사람 1명을 제외한 나머지 줄 세우는 경우의 수
    const idx = Math.floor(order / fact);
    order = order % fact;
    console.log(fact, idx, order);
    answer.push(lineUp[idx]);

    lineUp.splice(idx, 1);
  }
  return answer;
}
