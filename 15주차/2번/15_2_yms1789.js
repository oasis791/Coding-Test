function solution(k, d) {
  let answer = 0;
  for (let x = 0; x <= d; x += k) {
    const max_y = parseInt(Math.sqrt(d ** 2 - x ** 2));
    answer += parseInt(max_y / k) + 1;
  }
  return answer;
}
