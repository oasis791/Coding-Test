function solution(s) {
    let result_set = new Set();

    s = s.slice(2, s.length - 2).split("},{").reduce((arr, value) => {
        arr.push(value.split(','))
        return arr;
    }, []);

    s.sort((a, b) => a.length - b.length);

    for (let i = 0; i < s.length; i++)
        s[i].forEach((v) => result_set.add(v));

    return [...result_set].map(Number);
}