// [프로그래머스] 게임 맵 최단거리

function solution(maps) {
    let queue = [[0, 0, 1]];
    let move = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    while (queue.length) {
        position = queue.shift();
        // maps[position[0]][position[1]] = 0; // 시간초과, 큐에 넣는다는 것은 방문할 예정이라는 뜻이므로 중복 값이 들어가지 않도록 큐에 넣을때 방문 체크.
        if (position[0] === maps.length - 1 && position[1] === maps[0].length - 1) return position[2];

        for (let value of move) {
            nextX = position[0] + value[0];
            nextY = position[1] + value[1];
            if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length && maps[nextX][nextY]) {
                queue.push([nextX, nextY, position[2] + 1]);
                maps[nextX][nextY] = 0;
            }
        }
    }
    return -1;
}