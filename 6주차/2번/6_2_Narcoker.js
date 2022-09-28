function solution(arr) {
    let answer = arr[0];

    function uclid(a, b) {
        let [x, y] = a > b ? [a, b] : [b, a];
        while (y !== 0) {
            let z = x % y;
            x = y;
            y = z;
        }
        return (a * b) / x;
    }

    for (let i = 1; i < arr.length; i++)
        answer = uclid(answer, arr[i]);

    return answer;
}