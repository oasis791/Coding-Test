function solution(arr) {
    function getResult(y, x, len) {
        for (let i = y; i <= y + len; i += len) {
            for (let k = x; k <= x + len; k += len) {
                check(i, k, len);
            }
        }
    }
    function check(y, x, len) {
        let [zero, one] = [0, 0];
        for (let i = y; i < y + len; i++) {
            for (let k = x; k < x + len; k++) {
                if (arr[i][k] === 1) one++
                else zero++;
            }
        }

        if (one === 0) {
            answer[0]++;
            return;
        }
        if (zero === 0) {
            answer[1]++;
            return;
        }

        getResult(y, x, len / 2, len);
    }
    let answer = [0, 0];

    if (arr.flat().every((v) => v === arr[0][0]))
        answer[arr[0][0]]++;
    else getResult(0, 0, arr.length / 2, arr.length);

    return answer;
}