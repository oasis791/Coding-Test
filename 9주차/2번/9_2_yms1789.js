function solution(k, dungeons) {
  var answer = -1;
  let arr = Array(dungeons.length)
    .fill(0)
    .map((ele, idx) => ele + idx);
  const getPermutations = function (arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map((el) => [el]);
    arr.forEach((fixed, index, origin) => {
      const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
      const permutations = getPermutations(rest, selectNumber - 1);
      const attached = permutations.map((el) => [fixed, ...el]);
      results.push(...attached);
    });
    return results; // 결과 담긴 results return
  };
  arr = getPermutations(arr, dungeons.length);
  for (let i of arr) {
    let piro = k;
    let adventure = 0;
    for (let j of i) {
      if (piro >= dungeons[j][0]) {
        piro -= dungeons[j][1];
        adventure += 1;
      } else break;
    }
    answer = Math.max(answer, adventure);
  }
  return answer;
}
