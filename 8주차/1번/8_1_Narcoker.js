function solution(dartResult) {
    let scoreLog = [];
    let score = "";
    for (let i = 0; i < dartResult.length; i++) {
        if (Number.isInteger(dartResult[i] * 1)) { // 숫자인 경우
            score += dartResult[i];
        } else { // 보너스이거나 옵션인 경우
            switch (dartResult[i]) {
                case 'S':
                    score **= 1;
                    break;
                case 'D':
                    score **= 2;
                    break;
                case 'T':
                    score **= 3;
                    break;
                case '*':
                    scoreLog[scoreLog.length - 1] *= 2;
                    score *= 2;
                    break;
                case '#':
                    score *= -1;
                    break;
            }
            // 다음 글자가 숫자거나 없으면 Log에 push
            if (Number.isInteger(dartResult[i + 1] * 1) || i + 1 === dartResult.length) { 
                scoreLog.push(score);
                score = "";
            }

        }
    }
    return scoreLog.reduce((sum, v) => sum += v);
}