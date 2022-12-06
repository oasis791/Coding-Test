function solution(line) {
  let answer = [];
  let meets = [];
  for (let i = 0; i < line.length; i++) {
    let xasis;
    let yasis;
    const line1 = line[i];
    for (let j = 1; j < line.length; j++) {
      const line2 = line[j];
      const sameParallel = line1[0] * line2[1] - line1[1] * line2[0];
      if (sameParallel) {
        xasis = (line1[1] * line2[2] - line1[2] * line2[1]) / sameParallel;
        yasis = (line1[2] * line2[0] - line1[0] * line2[2]) / sameParallel;
        if (Number.isInteger(xasis) && Number.isInteger(yasis)) {
          meets.push([xasis, yasis]);
        }
      }
    }
  }
  const maxX = Math.max(...meets.map((meet) => meet[0]));
  const minX = Math.min(...meets.map((meet) => meet[0]));
  const maxY = Math.max(...meets.map((meet) => meet[1]));
  const minY = Math.min(...meets.map((meet) => meet[1]));

  let board = Array.from(Array(maxY - minY + 1), () =>
    Array(maxX - minX + 1).fill(".")
  );
  meets.forEach(([x, y]) => {
    board[maxY - y][x - minX] = "*";
  });

  //  const isMeets = (arr) => {
  //    for (let meet of meets) {
  //      if (JSON.stringify(arr) === JSON.stringify(meet)) {
  //        return true;
  //      }
  //    }
  //    return false;
  //  };

  //  for (let i = maxY; i >= minY; i--) {
  //    let str = "";
  //    for (let j = maxX; j >= minX; j--) {
  //      if (isMeets([j, i])) {
  //        str += "*";
  //      } else {
  //        str += ".";
  //      }
  //    }
  //    answer.push(str);
  //  }
  //  return answer;

  return board.map((x) => x.join(""));
}
