const [n, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
let result = [];
for (let i = 0; i < n; i++) {
  let count = input.shift();
  let employees = input
    .splice(0, count)
    .map((ele) => ele.split(" ").map(Number))
    .sort((a, b) => a[0] - b[0]);

  // 1차 시험 1등은 무조건 합격
  let interview = employees[0][1]; // 1차 시험 1등의 2차시험 점수
  let pass = 1;
  for (let j = 1; j < count; j++) {
    if (interview > employees[j][1]) {
      interview = employees[j][1];
      pass++;
    }
  }
  result.push(pass);
}
for (let k = 0; k < result.length; k++) {
  console.log(result[k]);
}
