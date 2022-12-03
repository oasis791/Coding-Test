function solution(s) {
  let answer = 0;
  const pair = { "}": "{", "]": "[", ")": "(" };
  s = s.split("");
  const isCorrect = (arr) => {};
  for (let i = 0; i < s.length; i++) {
    let stack = [];
    for (let ele of s) {
      if (pair[ele] === undefined) {
        // 여는 괄호
        stack.push(ele);
      } else {
        if (stack[stack.length - 1] !== pair[ele]) {
          stack.push(ele);
          break;
        }
        stack.pop();
      }
    }
    answer = stack.length === 0 ? answer + 1 : answer;
    s.push(s.shift());
  }
  return answer;
}
