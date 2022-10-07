function solution(lottos, win_nums) {
  let winCount = 0;
  let zeroCount = 0;
  let rank = {
    6: 1,
    5: 2,
    4: 3,
    3: 4,
    2: 5,
    1: 6,
    0: 6,
  };
  for (let i = 0; i < lottos.length; i++) {
    if (win_nums.indexOf(lottos[i]) >= 0) {
      winCount++;
    }
    if (lottos[i] === 0) {
      zeroCount++;
    }
  }
  return [rank[winCount + zeroCount], rank[winCount]];
}

// 1. 로또에서 당첨 번호가 총 몇 개 일치하는 가?
// 최저: 0이 전부 일치 안함, 최고: 0이 전부 일치 함
