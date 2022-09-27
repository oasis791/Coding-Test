function solution(n, words) {
  let answer;
  let order = 1;
  let num = 2;
  let preWord = words[0];
  let save = [preWord];
  for (let i = 1; i < words.length; i++) {
    if (
      words[i][0] === preWord[preWord.length - 1] &&
      !save.includes(words[i])
    ) {
      // 올바를 때
      if (num === n) {
        order++;
        num = 1;
      } else {
        num++;
      }
      preWord = words[i];
      save.push(preWord);
    } else {
      return [num, order];
    }
  }
  return [0, 0];
}
