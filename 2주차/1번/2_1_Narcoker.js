// [프로그래머스] 가장 큰 수
function solution(numbers) {
    var answer = numbers.map((x) => x + "").sort((a, b) => b + a - (a + b)).join("");
    return answer[0] === '0' ? '0' : answer;
}