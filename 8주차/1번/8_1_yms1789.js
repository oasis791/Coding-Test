function solution(dartResult) {
  let answer = 0;
  let nums = [];
  let bonus = [];
  let options = [];
  let num = "";
  let idx = 0;
  for (let i = 0; i < dartResult.length; i++) {
    switch (dartResult[i]) {
      case "S":
        nums[idx] = num / 1;
        bonus[idx] = 1;
        options[idx] = "";
        num = "";
        idx++;
        break;
      case "D":
        nums[idx] = num / 1;
        bonus[idx] = 2;
        options[idx] = "";
        num = "";
        idx++;
        break;
      case "T":
        nums[idx] = num / 1;
        bonus[idx] = 3;
        options[idx] = "";
        num = "";
        idx++;

        break;
      case "*":
      case "#":
        options[idx - 1] = dartResult[i];
        break;
      default:
        num += dartResult[i];
    }
  }
  for (let i = 0; i < nums.length; i++) {
    nums[i] **= bonus[i];

    if (options[i] !== "") {
      if (options[i] === "#") {
        nums[i] *= -1;
      }
      if (options[i] === "*") {
        if (i !== 0) nums[i - 1] *= 2;
        nums[i] *= 2;
      }
    }
  }
  answer = nums.reduce((a, b) => a + b);
  return answer;
}
