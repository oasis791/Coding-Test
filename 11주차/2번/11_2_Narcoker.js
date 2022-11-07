function solution(number) {
    let answer = 0;
    function search(sum, index, count) {
        if (count === 3) {
            if (!sum) answer++;
            else return;
        }
        for (let i = index; i < number.length; i++)
            search(sum + number[i], i + 1, count + 1);
    }
    search(0, 0, 0);
    return answer;
}