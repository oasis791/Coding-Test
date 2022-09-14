function solution(s) {
  let answer = s.split("");
  let index = 0;
  for (let i = 0; i < answer.length; i++) {
    if (answer[i] === " ") {
      index = -1;
    }
    if (index % 2 === 0) {
      answer[i] = answer[i].toUpperCase();
    } else {
      answer[i] = answer[i].toLowerCase();
    }
    index++;
  }

  return answer.join("");
}
