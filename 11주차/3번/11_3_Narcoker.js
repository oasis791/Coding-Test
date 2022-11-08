function solution(n) {
    let answer = BigInt(0);
    const fac = Array(n + 1).fill(BigInt(1));
    for (let i = 2; i < fac.length; i++)
        fac[i] = fac[i - 1] * BigInt(i);

    let twoMaxCount = Math.floor(n / 2);
    for (let r = 0; r <= twoMaxCount; r++) {
        answer += (fac[n] / (fac[n - r] * fac[r]));
        n--;
    }
    return Number(answer % BigInt(1234567));
}

// 피보나치 수열을 이용한 풀이
function solution(n) {
    let fib = Array(n + 1).fill(BigInt(1));
    for (let i = 2; i < fib.length; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }
    return Number(fib[n] % BigInt(1234567));
}