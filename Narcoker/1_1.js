function solution(progresses, speeds) {
    let result = [];
    while (progresses.length) {
        let days = Math.ceil((100 - progresses[0]) / speeds[0]);
        progresses = progresses.reduce(function (acc, value, i) {
            acc.push(value + speeds[i] * days);
            return acc;
        }, [])
        if (progresses[0] >= 100) {
            let count = 0;
            for (let k = 0; k < progresses.length; k++) {
                if (progresses[k] >= 100) {
                    count++;
                    progresses.shift();
                    speeds.shift();
                    k--;
                }
                else break;
            }
            result.push(count);
        }
    }
    return result;
}