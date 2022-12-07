function solution(citations) {
  let answer = 0;
  let candidateH = [];
  for (let i = 0; i <= Math.max(...citations); i++) {
    let h = i;
    let overH = citations.filter((ele) => ele >= h);
    if (overH.length >= h) {
      candidateH.push(h);
    }
  }
  answer = Math.max(...candidateH);
  return answer;
}
