let fs = require("fs");
let input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((str) => str.split(" ").map(Number));
let n = input[0][0];
let inf = Infinity;
let graph = Array.from(Array(n), () => Array(n).fill(inf));

for (let i = 0; i < n; i++) {
  graph[i][i] = 0;
}

for (let i = 2; i < input.length; i++) {
  const [x, y, cost] = input[i];
  graph[x - 1][y - 1] = Math.min(graph[x - 1][y - 1], cost);
}

for (let mid = 0; mid < n; mid++) {
  for (let start = 0; start < n; start++) {
    for (let end = 0; end < n; end++) {
      graph[start][end] = Math.min(
        graph[start][mid] + graph[mid][end],
        graph[start][end]
      );
    }
  }
}

for (let start = 0; start < n; start++) {
  for (let end = 0; end < n; end++) {
    if (graph[start][end] === inf) {
      graph[start][end] = 0;
    }
  }
}

console.log(graph.map((arr) => arr.join(" ")).join("\n"));
