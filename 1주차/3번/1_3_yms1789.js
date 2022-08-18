function solution(array, commands) {
  let answer = [];
  let slice = [];
  for (let i = 0; i < commands.length; i++) {
    slice = array.slice(commands[i][0] - 1, commands[i][1]);
    slice.sort((a, b) => a - b);
    answer.push(slice[commands[i][2] - 1]);
  }
  return answer;
}
