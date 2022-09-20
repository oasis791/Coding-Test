// [프로그래머스] 카펫

function solution(brown, yellow) {
    let size = brown + yellow;
    for (let i = 3; i <= Math.sqrt(size); i++) { // 세로 기준
        if (size % i === 0) {
            let k = size / i;
            if ((i - 2) * (k - 2) === yellow) return [k, i];
        }
    }
}
