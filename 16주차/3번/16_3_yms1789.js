function solution(arr) {
  let answer = [0, 0];
  function divcon(x, y, len) {
    if (len === 1) {
      return answer[arr[y][x]]++;
    }
    let tmp = [];

    for (let i = 0; i < len; i++) {
      tmp = tmp.concat(arr[y + i].slice(x, x + len));
    }
    let sum = tmp.reduce((acc, cur) => acc + cur, 0);

    if (sum === 0) {
      return answer[0]++;
    } else if (sum === len ** 2) {
      return answer[1]++;
    }
    len /= 2;

    divcon(x, y, len); // 1
    divcon(x + len, y, len); // 2
    divcon(x, y + len, len); // 3
    divcon(x + len, y + len, len); // 4
  }

  divcon(0, 0, arr.length);

  return answer;
}
