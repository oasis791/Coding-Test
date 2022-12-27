function solution(n, wires) {
    function dfs(start) {
        for (let end = 1; end <= n; end++) {
            if (visited[end] === false && graph[start][end] === 1) {
                visited[start] = true;
                count++;
                dfs(end);
                visited[start] = false;
            }
        }
    }

    let answer = Number.MAX_SAFE_INTEGER;
    let count = 1;
    const visited = Array(n + 1).fill(false);
    const graph = Array.from(Array(n + 1), () => Array(n + 1).fill(0));

    for (let [i, k] of wires) {
        graph[i][k] = 1;
        graph[k][i] = 1;
    }

    for (let [i, k] of wires) {
        graph[i][k] = 0;
        graph[k][i] = 0;
        count = 1;
        dfs(i);
        graph[i][k] = 1;
        graph[k][i] = 1;
        answer = Math.min(answer, Math.abs(n - count - count));
    }
    return answer;
}
console.log(solution(9, [[1, 3], [2, 3], [3, 4], [4, 5], [4, 6], [4, 7], [7, 8], [7, 9]]))