function solution(relation) {
    const getCombinations = function (arr, selectNumber) {
        const results = [];
        if (selectNumber === 1) return arr.map((el) => [el]);
        arr.forEach((fixed, index, origin) => {
            const rest = origin.slice(index + 1);
            const combinations = getCombinations(rest, selectNumber - 1);
            const attached = combinations.map((el) => [fixed, ...el]);
            results.push(...attached);
        });
        return results;
    }

    function check(key) {
        // 유일성 검사
        let testSet = new Set();
        for (let row of relation) {
            let data = "";
            for (let index of key) {
                data += row[index] + ",";
            }
            testSet.add(data);
        }
        if (testSet.size !== relation.length) return;
        // 최소성 검사
        for (let candidateKey of candidateKeys) {
            if (candidateKey.every((item) => key.includes(item)))
                return
        }
        candidateKeys.push(key)
    }

    let candidateKeys = [];
    let temp = Array.from(Array(relation[0].length), (x, i) => x = i);
    for (let count = 1; count <= relation[0].length; count++) {
        let keys = getCombinations(temp, count);
        for (let key of keys)
            check(key);
    }
    return candidateKeys.length;
}