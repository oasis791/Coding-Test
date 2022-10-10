function solution(priorities, location) {
    priorities = priorities.reduce((arr, value, i) => {
        arr.push([i, value]);
        return arr;
    }, []);
    let count = 0;
    while (true) {
        let curPrint = priorities.shift();
        let hasHigherValue = priorities.some(v => v[1] > curPrint[1]);
        if (hasHigherValue) priorities.push(curPrint);
        else {
            count++;
            if (curPrint[0] === location)
                break;
        }

    }
    return count;
}