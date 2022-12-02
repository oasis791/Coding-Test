function solution(line) {
    function getDot(data1, data2) {
        let [A, B, E] = [data1[0], data1[1], data1[2]];
        let [C, D, F] = [data2[0], data2[1], data2[2]];

        let x = (B * F - E * D) / (A * D - B * C);
        let y = (E * C - A * F) / (A * D - B * C);

        if (Number.isInteger(x) && Number.isInteger(y)) {
            xDots.push(x);
            yDots.push(y);
        }
    }

    let xDots = [];
    let yDots = [];
    for (let i = 0; i < line.length - 1; i++) {
        for (let k = i + 1; k < line.length; k++) {
            getDot(line[i], line[k]);
        }
    }
    let [xMax, xMin] = [Math.max(...xDots), Math.min(...xDots)];
    let [yMax, yMin] = [Math.max(...yDots), Math.min(...yDots)];

    let board = Array.from(Array(yMax - yMin + 1), () => Array(xMax - xMin + 1).fill('.'));

    for (let i = 0; i < xDots.length; i++) {
        board[yMax - yDots[i]][xDots[i] - xMin] = '*';
    }

    return board.map((x) => x.join(''));
}