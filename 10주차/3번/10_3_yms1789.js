function solution(n) {
  let binaryN = n.toString(2);
  let countOne = binaryN.split("").filter((ele) => ele === "1").length;
  let nextNum = n + 1;
  while (nextNum <= 1000000) {
    if (
      nextNum
        .toString(2)
        .split("")
        .filter((ele) => ele === "1").length === countOne
    )
      return nextNum;
    nextNum++;
  }
}
