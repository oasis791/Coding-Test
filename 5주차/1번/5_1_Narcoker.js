// [백준] 신입사원
let answer = "";
const fs = require('fs');
let testIndex = -1;
const input = fs.readFileSync('data.txt').toString().trim().split('\n').map(str => str.split(' ').map(Number))
    .slice(1)
    .reduce(function (arr, value) {
        if (value.length === 1) {
            arr.push(Array());
            testIndex++;
        }
        else {
            arr[testIndex].push(value);
        }
        return arr;
    }, []);

for (let i = 0; i < input.length; i++) {
    input[i] = input[i].sort((a, b) => a[0] - b[0]);
    let count = 1;
    let standard = input[i][0][1];
    for (let logIndex = 1; logIndex < input[i].length; logIndex++) {
        if (standard > input[i][logIndex][1]) {
            count++;
            standard = input[i][logIndex][1];
        }
    }
    answer += count + "\n"
}

console.log(answer);