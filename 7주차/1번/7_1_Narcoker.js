function solution(lottos, win_nums) {
    let lank = [6, 6, 5, 4, 3, 2, 1];
    let collect = 0;
    let zero = 0;
    for (let i = 0; i < lottos.length; i++) {
        if (lottos[i] === 0) zero++;
        else {
            if (win_nums.indexOf(lottos[i]) > -1)
                collect++;
        }
    }
    return [lank[collect + zero], lank[collect]];
}