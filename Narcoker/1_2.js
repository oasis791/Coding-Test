// [프로그래머스] 게임 맵 최단거리

function solution(maps) {
    let queue = [[0, 0, 1]];
    let move = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    while (queue.length) {
        position = queue.shift();
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