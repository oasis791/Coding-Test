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
/* 또 다른 풀이(with, 객체 카운터) */
// function solution(participant, completion) {
//   let answer = "";
//   let freqCounter1 = {};
//   let freqCounter2 = {};
//   participant.forEach((val) => {
//     freqCounter1[val] = (freqCounter1[val] || 0) + 1;
//   });
//   completion.forEach((val) => {
//     freqCounter2[val] = (freqCounter2[val] || 0) + 1;
//   });
//   Object.keys(freqCounter1).forEach((key) => {
//     if (!(key in freqCounter2) || freqCounter2[key] !== freqCounter1[key]) {
//       answer = key;
//     }
//   });
//   return answer;
// }