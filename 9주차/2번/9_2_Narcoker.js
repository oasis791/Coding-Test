function solution(k, dungeons) {
    let answer = -1;
    let dungeonsCount = dungeons.length;
    const canGo = Array(dungeonsCount).fill(true);

    function travel(canGo, count, restHP) {
        if (count > answer) answer = count;

        const newCanGo = [...canGo];

        for (let i = 0; i < dungeonsCount; i++) {
            if (restHP < dungeons[i][0])
                newCanGo[i] = false;
        }

        const isRemain = newCanGo.some(v => v === true);

        if (!isRemain) return;

        for (let i = 0; i < dungeonsCount; i++) {
            if (newCanGo[i]) {
                newCanGo[i] = false;
                travel(newCanGo, count + 1, restHP - dungeons[i][1]);
                newCanGo[i] = true;
            }
        }
    }
    travel(canGo, 0, k);

    return answer;
}