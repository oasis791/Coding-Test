function solution(survey, choices) {
    let answer = "";
    let type = "RTCFJMAN"
    let result = new Map();
    for (let i = 0; i < type.length; i++)
        result.set(type[i], 0);

    for (let i = 0; i < choices.length; i++) {
        if (choices[i] < 4) {
            result.set(survey[i][0], result.get(survey[i][0]) + 4 - choices[i])
        } else if (choices[i] > 4) {
            result.set(survey[i][1], result.get(survey[i][1]) + choices[i] - 4)
        }
    }

    result.get("R") - result.get("T") >= 0 ? answer += 'R' : answer += 'T';
    result.get("C") - result.get("F") >= 0 ? answer += 'C' : answer += 'F';
    result.get("J") - result.get("M") >= 0 ? answer += 'J' : answer += 'M';
    result.get("A") - result.get("N") >= 0 ? answer += 'A' : answer += 'N';

    return answer;
}