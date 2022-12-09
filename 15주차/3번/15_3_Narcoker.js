function solution(arrayA, arrayB) {
    const getGCD = (a, b) => b ? getGCD(b, a % b) : a;
    const getResult = (arr, GCD) => {
        for (let i = GCD; i > 1; i--)
            if (GCD % i === 0 && !arr.some(b => b % i === 0)) return i;
        return 0;
    }

    let AGCD = arrayA.reduce((res, value) => getGCD(res, value));
    let BGCD = arrayB.reduce((res, value) => getGCD(res, value));

    let Aresult = getResult(arrayB, AGCD);
    let Bresult = getResult(arrayA, BGCD);

    return Math.max(Aresult, Bresult);
}
