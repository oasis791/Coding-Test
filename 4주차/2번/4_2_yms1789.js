function solution(brown, yellow) {
  let answer;
  let y = 1;
  while (true) {
    let findY =
      Math.pow(y, 2) - (2 + Math.floor(brown / 2)) * y + brown + yellow;
    if (findY === 0) {
      answer = [Math.floor(brown / 2) + 2 - y, y];
      break;
    }
    y++;
  }

  return answer;
}
