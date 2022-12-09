function solution(k, tangerine) {
    var answer = 0;
    let tangerineCount = new Map();
    tangerine.forEach((value) => tangerineCount.set(value, tangerineCount.get(value) + 1 || 1));

    for (let [_, count] of [...tangerineCount].sort((a, b) => (b[1] - a[1]))) {
        k -= count;
        answer++;
        if (k <= 0) break;
    }
    return answer;
}