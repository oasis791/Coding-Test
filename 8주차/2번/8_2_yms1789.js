function solution(priorities, location) {
  let answer = 0;
  let order = 1;
  let locArray = Array(priorities.length).fill(0);
  priorities = priorities.map((ele, idx) => [ele, idx]);
  while (priorities.length) {
    let proc = priorities[0];
    // [우선순위, 인덱스]
    if (priorities.some((ele) => proc[0] < ele[0])) {
      // 하나라도 중요도가 더 큰게 있다면
      priorities.shift();
      priorities.push(proc);
    } else {
      let print = priorities.shift();
      locArray[print[1]] = order;
      order++;
    }
  }
  answer = locArray[location];
  return answer;
}
