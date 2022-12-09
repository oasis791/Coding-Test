function solution(k, d) {
    var answer = 0;
    for (let i = 0; i <= d; i += k) {
        let y = Math.sqrt(d ** 2 - i ** 2);
        answer += Math.floor(y / k) + 1;
    }
    return answer;
}