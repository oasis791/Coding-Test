// function solution(m, musicinfos) {
//     function makePlayTime(start, end) {
//         let [startHour, startMinite] = start.split(":").map(Number);
//         let [endHour, endMinite] = end.split(":").map(Number);
//         return (endHour * 60 + endMinite) - (startHour * 60 + startMinite);
//     }

//     let answer = ["(None)", "", 0];
//     const changeSoundMap = {
//         "C#": "1",
//         "D#": "2",
//         "F#": "3",
//         "G#": "4",
//         "A#": "5",
//     }
//     for (let key of Object.keys(changeSoundMap))
//         m = m.replaceAll(key, changeSoundMap[key]);

//     musicinfos.forEach((info) => {
//         let [start, end, name, sounds] = info.split(",");
//         let playTime = makePlayTime(start, end);
//         for (let key of Object.keys(changeSoundMap))
//             sounds = sounds.replaceAll(key, changeSoundMap[key]);
//         let playSounds = sounds.repeat(Math.ceil(playTime / sounds.length)).slice(0, playTime);

//         if (playSounds.includes(m)) {
//             if (answer[1].length < m.length) {
//                 answer = [name, m, playTime];
//             }
//             if (answer[1].length === m.length) {
//                 answer = playTime > answer[2] ? [name, m, playTime] : answer;
//             }
//         }
//     });

//     return answer[0] ? "" : "(None)", answer[0];
// }

function solution(m, musicinfos) {
    function makePlayTime(start, end) {
        let [startHour, startMinite] = start.split(":").map(Number);
        let [endHour, endMinite] = end.split(":").map(Number);
        return (endHour * 60 + endMinite) - (startHour * 60 + startMinite);
    }

    let answer = ["(None)", "", 0];
    m = m.replace(/\w#/g, char => char[0].toLowerCase());

    musicinfos.forEach((info) => {
        let [start, end, name, sounds] = info.split(",");
        sounds = sounds.replace(/\w#/g, char => char[0].toLowerCase());

        let playTime = makePlayTime(start, end);
        let playSounds = sounds.repeat(Math.ceil(playTime / sounds.length)).slice(0, playTime);

        if (playSounds.includes(m)) {
            if (answer[1].length < m.length)
                answer = [name, m, playTime];

            if (answer[1].length === m.length)
                answer = playTime > answer[2] ? [name, m, playTime] : answer;
        }
    });

    return answer[0] ? "" : "(None)", answer[0];
}