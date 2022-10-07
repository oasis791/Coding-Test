function solution(msg) {
  let answer = [];
  let dic = [];
  for (let i = 0; i < 26; i++) {
    dic.push(String.fromCharCode(65 + i));
  }

  while (msg.length > 0) {
    let w;
    let wc;
    let sliceIdx = 0;
    for (let i = 0; i < msg.length; i++, sliceIdx++) {
      w = msg.slice(0, i);
      wc = msg.slice(0, i + 1);
      if (dic.indexOf(wc) < 0) {
        answer.push(dic.indexOf(w) + 1);
        break;
      }
      if (i === msg.length - 1) {
        answer.push(dic.indexOf(wc) + 1);
      }
    }
    dic.push(wc);
    msg = msg.slice(sliceIdx);
  }
  return answer;
}
