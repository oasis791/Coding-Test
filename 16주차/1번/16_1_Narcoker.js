function solution(cards) {
    let groups = [];
    let use = new Set();
    let remain = cards.length;
    while (remain > 0) {
        let group = [];
        let curIndex = 0;
        for (let i = 0; i < cards.length; i++) {
            if (!use.has(i)) break;
            curIndex++;
        }
        while (true) {
            if (group.includes(cards[curIndex])) break;
            group.push(cards[curIndex]);
            remain--;
            use.add(curIndex);
            curIndex = group.at(-1) - 1;
        }
        groups.push(group);
    }
    groups.sort((a, b) => b.length - a.length);
    return groups[0].length * groups[1]?.length || 0;
}