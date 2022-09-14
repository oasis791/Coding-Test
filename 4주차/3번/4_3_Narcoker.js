// [백준] 플로이드

const fs = require('fs');
const input = fs.readFileSync("data.txt").toString().trim().split("\n").map(str => str.split(' ').map(Number));
const [country, bus] = [input[0][0], input[1][0]]
const input_map = input.slice(2);
let map = Array.from(Array(country), () => new Array(country).fill(Infinity));
input_map.forEach((value) => {
    let [x, y, dis] = value;
    if (map[x - 1][y - 1] > dis) map[x - 1][y - 1] = dis;
})

for (let mid = 0; mid < country; mid++) { // 중간
    for (let start = 0; start < country; start++) { // 출발
        for (let end = 0; end < country; end++) { // 도착
            if (start === end) continue;
            if (map[start][end] > map[start][mid] + map[mid][end])
                map[start][end] = map[start][mid] + map[mid][end]
        }
    }
}

for (let i = 0; i < country; i++) {
    for (let k = 0; k < country; k++) {
        if (map[i][k] === Infinity) map[i][k] = 0;
    }
    console.log(map[i].slice(0, country).join(" "));
}