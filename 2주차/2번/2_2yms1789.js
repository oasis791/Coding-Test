function solution(participant, completion) {
  var answer = "";
  participant = participant.sort();
  completion = completion.sort();
  for (let i = participant.length - 1; i >= 0; i--) {
    if (completion[i] !== participant[i]) {
      answer = participant[i];
    } else {
      completion.pop();
    }
  }
  return answer;
}

/*** 
 * 기존풀이(시간초과) O(forEach * arrayMethod) == O(n^2)
var answer = "";
participant.forEach((person) => {
  if (!completion) {
    return;
  }
  if (completion.includes(person)) {
    idx = completion.findIndex((element) => element === person);
    completion.splice(idx, 1);
  } else {
    answer = person;
  }
});
*/
