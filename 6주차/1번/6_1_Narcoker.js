function solution(n) {
    let answer = [];
    function get124(share) {
        let nextShare = Math.floor(share / 3);
        let pushNum = share % 3;
        if (pushNum === 0) {
            answer.push(4);
            nextShare--;
        } else {
            answer.push(pushNum);
        }

        if (nextShare === 0) return;
        else get124(nextShare);
    }
    get124(n);
    return answer.reverse().join('');
}