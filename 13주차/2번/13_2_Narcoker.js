function solution(orders, course) {
    function getCombination(arr, number) {
        const result = [];
        if (number === 1) return arr.map((el) => [el]);

        arr.forEach((fixed, index, origin) => {
            const rest = origin.slice(index + 1);
            const combination = getCombination(rest, number - 1);
            const attached = combination.map((el) => [fixed, ...el].join(''));
            result.push(...attached);
        });
        return result;
    }

    let answer = [];

    for (let number of course) {
        let menus = new Map();
        for (let order of orders) {
            let combinationMenu = getCombination(order.split('').sort(), number);
            for (let menu of combinationMenu)
                menus.set(menu, menus.get(menu) + 1 || 1);
        }

        console.log(menus);

        let maxCount = Math.max(...menus.values());
        menus.forEach((count, menu) => {
            if (count === maxCount && count >= 2) answer.push(menu);
        })
    }

    return answer.sort();
}