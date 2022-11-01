function solution(queue1, queue2) {
    let sum = 0, count = 0, avg = 0;
    let start = 0, end = queue1.length;
    let queue = [...queue1, ...queue2, ...queue1, ...queue2];
    for (let i = 0; i < queue1.length; i++) {
        avg += queue1[i] + queue2[i];
        sum += queue1[i];
    }
    if (Number.isInteger(avg / 2)) {
        avg /= 2;
    } else return -1;

    while (count < queue.length) {
        if (sum > avg) {
            sum -= queue[start];
            start++;
            count++;
        } else if (sum < avg) {
            sum += queue[end];
            end++;
            count++;
        } else {
            return count;
        }
    }

    return -1;

}