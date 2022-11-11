function solution(a, b, n) {
    let answer = 0;
    let remainBottle = n;
    while (remainBottle >= a) {
        let getBottle = Math.floor(remainBottle / a) * b;
        let changeBottle = (remainBottle % a);

        answer += getBottle;
        remainBottle = getBottle + changeBottle;
    }
    return answer;
}