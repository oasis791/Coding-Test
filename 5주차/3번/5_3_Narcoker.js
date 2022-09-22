function solution(n, info) {
    let answer = [];
    let lionInfo = Array(11).fill(0);
    let score = 0;
    function search(arrow, lionInfo, index) {
        if (arrow < 0) return;

        if (arrow === 0) {
            let [apeachScore, lionScore] = [0, 0];
            let diff;
            for (let i = 0; i < 11; i++) { // 점수 계산
                if (info[i] || lionInfo[i]) {
                    info[i] - lionInfo[i] >= 0 ? apeachScore += 10 - i : lionScore += 10 - i;
                }
            }

            diff = lionScore - apeachScore;
            if (diff === 0) return; // 비기는 경우

            // 이긴 경우
            if (score < diff) { // 최대차인 경우
                score = diff;
                answer = lionInfo;
            } else if (score === diff) {
                if ([...answer].reverse().join("") < [...lionInfo].reverse().join(""))
                    answer = lionInfo;
            }
            return;
        }

        for (let i = index; i < 11; i++) {
            if (arrow > lionInfo[i]) {
                let nextLineInfo = [...lionInfo];
                if (info[i] + 1 < arrow) // 화살 개수가 넉넉한 경우
                    nextLineInfo[i] = info[i] + 1;
                else { // 화살 개수가 모자란 경우
                    nextLineInfo[i] = arrow;
                }
                search(arrow - nextLineInfo[i], nextLineInfo, i + 1);

            }
        }
    }

    search(n, lionInfo, 0)
    return answer.length === 0 ? [-1] : answer
}
console.log(solution(1, [1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1]));