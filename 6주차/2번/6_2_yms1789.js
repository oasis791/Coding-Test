function solution(arr) {
  // 두 수 a, b의 lcm = a * b / gcd
  // 뒤에서부터 두 숫자씩 꺼내서 최소공배수를 구해나가자
  let answer = 0;
  arr = arr.sort((a, b) => a - b);
  function gcd(a, b) {
    if (b === 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
  function lcm(a, b) {
    return Math.round((a * b) / gcd(a, b));
  }
  while (arr.length >= 2) {
    let a = arr.pop();
    let b = arr.pop();
    arr.push(lcm(a, b));
  }

  answer = arr[0];
  return answer;
}
