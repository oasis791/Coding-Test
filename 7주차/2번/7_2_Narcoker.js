function solution(msg) {
    let dic = new Map();
    let maxCount = 26;
    for (let i = 0; i <= 25; i++)
        dic.set(String.fromCharCode(i + 65), i + 1);
    let answer = [];
    let w = msg[0];
    let c = "";
    for (let i = 1; i < msg.length; i++) {
        c = msg[i];
        w += c;
        if (dic.has(w)) {
            continue;
        } else {
            let pushValue = w.slice(0, w.length - 1);
            answer.push(dic.get(pushValue));
            dic.set(w, ++maxCount);
            w = w.slice(pushValue.length);
        }
    }
    answer.push(dic.get(w))
    return answer;
}