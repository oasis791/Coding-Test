// [프로그래머스] 영어 끝말잇기
function solution(n, words) {
    let answer = [0, 0];
    let wordLog = new Set([words[0]]);
    let lastChar = words[0].at(-1);
    for (let index = 1; index < words.length; index++) {
        if (!wordLog.has(words[index]) && lastChar === words[index].at(0)) {
            wordLog.add(words[index]);
            lastChar = words[index].at(-1);
        }
        else {
            answer = [(index % n) + 1, Math.ceil((index + 1) / n)];
            break;
        }
    }
    return answer;
}