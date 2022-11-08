function solution(number) {
  let answer = 0;
  function getCombination(arr, selectNum) {
    const res = [];
    if (selectNum === 1) return arr.map((ele) => [ele]);
    arr.forEach((fixed, index, origin) => {
      const rest = origin.slice(index + 1);
      const combinations = getCombination(rest, selectNum - 1);
      const attach = combinations.map((ele) => [fixed, ...ele]);
      res.push(...attach);
    });
    return res;
  }
  let selectMusketeers = getCombination(number, 3);
  selectMusketeers = selectMusketeers.filter(
    (ele) => ele.reduce((acc, cur) => acc + cur, 0) === 0
  );
  answer = selectMusketeers.length;
  return answer;
}
