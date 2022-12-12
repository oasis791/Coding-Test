function solution(k, tangerine) {
  let answer = 0;
  let obj = {};
  for (let tangerineContent of tangerine) {
    obj[tangerineContent] = (obj[tangerineContent] || 0) + 1;
  }
  let contentList = [];
  for (let objIndex in obj) {
    contentList.push([objIndex, obj[objIndex]]);
  }
  contentList.sort((a, b) => b[1] - a[1]);
  let count = 0;
  for (let content of contentList) {
    count += content[1];
    answer++;
    if (count >= k) {
      break;
    }
  }

  return answer;
}
