// [프로그래머스] 구명보트

function solution(people, limit) {
    let answer = 0;
    let boat_remain;
    let first = 0, last = people.length - 1;
    people.sort((a, b) => b - a);

    while (first <= last) {
        answer++;
        boat_remain = limit - people[first];
        if (first === last) break;
        if (boat_remain - people[last] >= 0) {
            boat_remain -= people[last];
            last--;
        }
        first++;
    }
    return answer;
}