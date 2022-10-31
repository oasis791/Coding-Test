function solution(queue1, queue2) {
  var answer = 0;
  let concatQueue = [].concat(queue1, queue2);
  let hap = Math.floor(concatQueue.reduce((acc, cur) => acc + cur, 0) / 2);
  let i = 0;
  let j = queue1.length - 1;
  let queue1Hap = queue1.reduce((acc, cur) => acc + cur, 0);
  while (i < concatQueue.length && j < concatQueue.length) {
    if (queue1Hap === hap) {
      return answer;
    } else if (queue1Hap < hap && j < concatQueue.length - 1) {
      j++;
      queue1Hap += concatQueue[j];
    } else {
      queue1Hap -= concatQueue[i];
      i++;
    }
    answer++;
  }
  return -1;
}
