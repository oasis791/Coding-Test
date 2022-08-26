function solution(people, limit) {
  let answer = 0;
  people = people.sort((a, b) => b - a);
  let head = 0;
  let tail = people.length - 1;
  while (head <= tail) {
    if (people[head] + people[tail] <= limit) {
      head++;
      tail--;
      answer++;
    } else {
      head++;
      answer++;
    }
  }
  return answer;
}
// 처음 생각해낸 방법
// function solution(people, limit) {
//   let answer = 0;
//   people = people.sort((a, b) => b - a);
//   while (people.length > 0) {
//     let len = people.length;
//     if (people[len - 1] + people[len - 2] <= limit) {
//       people.pop();
//       people.pop();
//       answer++;
//     } else {
//       people.pop();
//       answer++;
//     }
//   }
//   return answer;
// }

// 두번째 생각해낸 방법
// function solution(people, limit) {
//   let answer = 0;
//   people = people.sort((a, b) => b - a);

//   while (people.length > 0) {
//     if (people[head] + people[tail] <= limit) {
//       people.pop();
//       people.shift();
//       answer++;
//     } else {
//       people.shift();
//       answer++;
//     }
//   }
//   return answer;
// }
