function solution(s) {
    function check(index) {
        let stack = [];
        for (let i = index; i < index + s.length; i++) {
            if (stack.at(-1) === '[' && sDouble[i] === ']') {
                stack.pop();
                continue;
            }

            if (stack.at(-1) === '(' && sDouble[i] === ')') {
                stack.pop();
                continue;
            }

            if (stack.at(-1) === '{' && sDouble[i] === '}') {
                stack.pop();
                continue;
            }
            stack.push(sDouble[i]);
        }

        return stack.length === 0 ? true : false;
    }

    let answer = 0;
    let sDouble = s + s;
    for (let i = 0; i < s.length; i++) {
        if (check(i)) answer++;
    }

    return answer;
}