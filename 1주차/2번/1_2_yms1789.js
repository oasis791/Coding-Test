function solution(maps) {
  let answer = 0;
  const n = maps.length;
  const m = maps[0].length;
  const visited = [];
  for (let i = 0; i < n; i++) {
    visited[i] = new Array(m).fill(0);
  }

  function bfs(x, y) {
    const dx = [1, -1, 0, 0];
    const dy = [0, 0, 1, -1];
    const queue = [];
    queue.push({ x: x, y: y });
    visited[x][y] = 1;
    while (queue.length) {
      const { x, y } = queue.shift();
      for (let i = 0; i < dx.length; i++) {
        const nx = x + dx[i];
        const ny = y + dy[i];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (visited[nx][ny] === 0 && maps[nx][ny]) {
            visited[nx][ny] = visited[x][y] + 1;
            queue.push({ x: nx, y: ny });
          }
        }
      }
    }
  }

  bfs(0, 0);
  answer = visited[n - 1][m - 1] > 0 ? visited[n - 1][m - 1] : -1;
  return answer;
}
