function solution(s) {
  let answer = [];
  let dup = new Set();
  function comareLength(a, b) {
    if (a.length > b.length) {
      return 1;
    } else {
      return -1;
    }
  }
  s = s
    .slice(2, s.length - 2)
    .split("},{")
    .sort(comareLength)
    .join(",")
    .split(",");
  for (let i = 0; i < s.length; i++) {
    dup.add(parseInt(s[i]));
  }
  answer = Array.from(dup);
  return answer;
}
