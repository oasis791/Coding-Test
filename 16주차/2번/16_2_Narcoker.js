function solution(n) {
    function assign(y, x, num, type) {
        if (type === '0') { // 아래
            arr[y + 1][x] = num;
            return [y + 1, x]
        }
        if (type === '1') { // 오른쪽
            arr[y][x + 1] = num;
            return [y, x + 1];
        }
        if (type === '2') { // 위
            arr[y - 1][x - 1] = num;
            return [y - 1, x - 1];
        }
    }
    const arr = [];
    let move = ""

    for (let i = 0; i < n; i++) {
        arr.push(Array(i + 1).fill(0));
        move += (i % 3 + "").repeat(n - i);
    }

    let curY = -1;
    let curX = 0;
    let num = 1;
    for (let i = 0; i < move.length; i++) {
        [curY, curX] = assign(curY, curX, num, move[i]);
        num++;
    }
    return arr.flat();
}