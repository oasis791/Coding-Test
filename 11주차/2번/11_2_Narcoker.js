function solution(n, k) {
    let answer = [];
    let numbers = Array.from({ length: n }, (v, i) => i + 1);
    let facResult = 1;
    for (let i = 1; i <= n; i++)
        facResult *= i;
    while (n) {
        let groupCount = Math.floor(facResult / n);
        let share = Math.floor(k / groupCount);
        let remainder = k % groupCount;

        if (remainder === 0) share--;
        answer.push(numbers[share]);
        numbers.splice(share, 1);
        if (remainder === 0) {
            answer = [...answer, ...numbers.reverse()];
            break;
        } else if (remainder === 1) {
            answer = [...answer, ...numbers];
            break;
        }

        facResult /= n;
        n--;
        k = remainder;
    }
    return answer;
}
