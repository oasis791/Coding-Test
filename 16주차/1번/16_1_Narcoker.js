function solution(cards) {
    let groups = [];
    let use = new Set();

    while (use.size !== cards.length) {
        let group = [];
        let curIndex = 0;
        for (let i = 0; i < cards.length; i++) {
            if (!use.has(i)) break;
            curIndex++;
        }
        while (true) {
            if (group.includes(cards[curIndex])) break;
            group.push(cards[curIndex]);
            use.add(curIndex);
            curIndex = group.at(-1) - 1;
        }
        groups.push(group);
    }
    groups.sort((a, b) => b.length - a.length);
    return groups[0].length * groups[1]?.length || 0;
}