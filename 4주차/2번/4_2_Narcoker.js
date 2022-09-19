// [프로그래머스] 카펫

function solution(brown, yellow) {
    let sum = brown + yellow;
    for (let i = 3; i <= Math.sqrt(sum); i++) { // 세로 기준
        if (sum % i === 0) {
            let k = sum / i;
            if ((i - 2) * (k - 2) === yellow) return [k, i];
        }
    }
}
