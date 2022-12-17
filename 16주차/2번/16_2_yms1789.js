function solution(n) {
  let answer = [];
  let count = 0;
  let arr = Array.from({ length: n }, (_, index) => Array(index + 1).fill(0));

  let curX = -1;
  let curY = 0;
  while (n > 0) {
    for (let i = 0; i < n; i++) {
      curX++;
      count++;
      arr[curX][curY] = count;
    }
    n--;
    for (let i = 0; i < n; i++) {
      curY++;
      count++;
      arr[curX][curY] = count;
    }
    n--;
    for (let i = 0; i < n; i++) {
      curX--;
      curY--;
      count++;
      arr[curX][curY] = count;
    }
    n--;
  }
  answer = arr.flat();
  return answer;
}
