// [프로그래머스] 거리두기 확인하기
let answer = [1, 1, 1, 1, 1];
let visited;

function dfs(room, map, curX, curY, dis) {
    let move = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    let nextX, nextY, nextDis = dis + 1;
    visited[curX][curY] = true;
    if (nextDis > 2) return;
    for (let value of move) {
        nextX = curX + value[0];
        nextY = curY + value[1];

        if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && visited[nextX][nextY] === false) {
            if (map[nextX][nextY] === 'P') {
                answer[room] = 0;
                return;
            }
            else if (map[nextX][nextY] === 'O') {
                dfs(room, map, nextX, nextY, nextDis);
            }
        }
    }
}

function solution(places) {
    for (let room = 0; room < 5; room++) {
        visited = Array.from(Array(5), () => Array(5).fill(false));
        for (let i = 0; i < 5; i++) {
            for (let k = 0; k < 5; k++) {
                if (places[room][i][k] === 'P')
                    dfs(room, places[room], i, k, 0);
            }
        }
    }
    return answer;
}