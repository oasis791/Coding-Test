function solution(N, road, K) {
  let answer = 0;
  const graph = Array(N + 1)
    .fill(0)
    .map(() => Array());
  let dist = Array(N + 1).fill(Infinity);
  let queue = [];
  for (let i = 0; i < road.length; i++) {
    let [start, to, cost] = road[i];
    graph[start].push([to, cost]);
    graph[to].push([start, cost]);
  }
  queue.push([1, 0]);
  dist[1] = 0;
  while (queue.length) {
    const [current, cost] = queue.shift();
    for (let i = 0; i < graph[current].length; i++) {
      let [next, nextCost] = [graph[current][i][0], graph[current][i][1]];
      if (dist[next] > dist[current] + nextCost) {
        dist[next] = dist[current] + nextCost;
        queue.push([next, nextCost]);
      }
    }
  }
  for (let i = 0; i < dist.length; i++) {
    answer += dist[i] <= K ? 1 : 0;
  }
  return answer;
}
