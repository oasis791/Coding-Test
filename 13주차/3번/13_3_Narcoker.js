function solution(want, number, discount) {
    function canSignUp(discountCount) {
        for (let name of wantMap.keys()) {
            if (!discountCount.has(name)) return false;
            if (discountCount.get(name) !== wantMap.get(name)) return false;
        }
        return true;
    }

    let answer = 0;
    let canSignUpDays = discount.length - 10 + 1;
    let wantMap = want.reduce((res, item, i) => {
        res.set(item, number[i]);
        return res;
    }, new Map());

    for (let day = 0; day < canSignUpDays; day++) {
        let itemNames = discount.slice(day, day + 10);
        let discountCount = itemNames.reduce((res, item) => {
            res.set(item, res.get(item) + 1 || 1);
            return res;
        }, new Map());

        if (canSignUp(discountCount)) answer++;
    }
    return answer;
}