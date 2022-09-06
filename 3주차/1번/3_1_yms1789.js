function solution(s) {
  let answer = -1;
  let stack = [];
  for (let i = 0; i < s.length; i++) {
    let pair = s[i];
    if (stack.length > 0 && stack[stack.length - 1] === pair) {
      stack.pop();
    } else {
      stack.push(pair);
    }
  }
  answer = stack.length === 0 ? 1 : 0;
  return answer;
}
