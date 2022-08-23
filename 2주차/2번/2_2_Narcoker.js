// [프로그래머스] 완주하지 못한 선수

function solution(participant, completion) {
    let result;
    const map = new Map();
    participant.forEach(function (name) {
        if (map.has(name))
            map.set(name, map.get(name) + 1);
        else map.set(name, 1);
    });

    completion.forEach(function (name) {
        if (map.has(name)) {
            if (map.get(name) === 1)
                map.delete(name);
            else
                map.set(name, map.get(name) - 1);
        }
    });

    map.forEach(function (value, key) {
        result = key;
    })

    return result;
}