function solution(n, info) {
  let maxDiff = 0;
  let ryon = Array(11).fill(0);
  function shot(pScore, rScore, arrow, idx, ryonInfo) {
    if (n < arrow)
      // 화살 쏜 개수가 n 보다 크면
      return;
    if (idx > 10) {
      // 10점 과녁까지 다 돌았을 때
      let diff = rScore - pScore;
      if (diff > maxDiff) {
        ryonInfo[10] = n - arrow;
        maxDiff = diff;
        ryon = ryonInfo;
      }
      return;
    }
    if (n > arrow) {
      // 라이언이 이긴 경우
      let copy = [...ryonInfo];
      copy[10 - idx] = info[10 - idx] + 1;
      shot(pScore, rScore + idx, arrow + info[10 - idx] + 1, idx + 1, copy);
    }
    if (info[10 - idx] > 0) {
      // 어피치가 이긴 경우
      shot(pScore + idx, rScore, arrow, idx + 1, ryonInfo);
    } else {
      // 둘 다 0
      shot(pScore, rScore, arrow, idx + 1, ryonInfo);
    }
  }
  shot(0, 0, 0, 0, ryon);
  return maxDiff > 0 ? ryon : [-1];
}
