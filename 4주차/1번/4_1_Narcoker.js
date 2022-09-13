// [프로그래머스] 이상한 문자 만들기

function solution(s) {
    let words = s.split(" ").reduce((arr, word) => {
        let temp = "";
        for (let i = 0; i < word.length; i++) {
            let ascii = word[i].charCodeAt(0);
            let c;
            if (i % 2 === 0 && ascii >= 97 && ascii <= 122) {
                c = word[i].toUpperCase();
            } else if (i % 2 === 1 && ascii >= 65 && ascii <= 90) {
                c = word[i].toLowerCase();
            } else {
                c = word[i];
            }
            temp += c;
        }
        arr.push(temp);
        return arr;
    }, [])

    return words.join(" ");
}

