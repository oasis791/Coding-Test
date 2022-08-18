function solution(progresses, speeds) {
  let answer = [];
  let tasks = [...progresses];
  let taskSpeeds = [...speeds];
  while (tasks.length) {
    let count = 0;
    tasks.forEach((task, idx) => {
      tasks[idx] += taskSpeeds[idx];
    });
    if (tasks[0] >= 100) {
      let length = tasks.length;
      for (let i = 0; i < length; i++) {
        if (tasks[0] >= 100) {
          tasks.shift();
          taskSpeeds.shift();
          count++;
        } else {
          break;
        }
      }
      answer.push(count);
    }
  }
  return answer;
}
