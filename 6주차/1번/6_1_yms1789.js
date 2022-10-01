// 1. n을 3으로 나눈 나머지로 맨끝자리를 확인
// 1-1. 나누어떨어지면 4, 나머지가 1 ? 1 : 2
// 2. n을 3으로 나눈 몫을 n으로 치환
// 3. 위 2가지를 반복하기 (나눠지지 않을때까지?)

function solution(n) {
  let answer = [];
  let otf = ["4", "1", "2"];
  function recursive(n) {
    if (n < 1) return;
    const remain = n % 3;
    answer.unshift(otf[remain]); // 처음 들어가는 값이 끝 값이 되어야 함
    recursive(Math.floor((n - 1) / 3));
  }
  recursive(n);
  return answer.join("");
}
