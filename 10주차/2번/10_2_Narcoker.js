function solution(N, road, K) {
    let answer = 0;
    const mapInfo = Array.from(Array(N), () => Array(N).fill(Infinity))
    for (let info of road) {
        if (mapInfo[info[0] - 1][info[1] - 1] > info[2]) {
            mapInfo[info[0] - 1][info[1] - 1] = info[2];
            mapInfo[info[1] - 1][info[0] - 1] = info[2];
        }
    }

    for (let i = 0; i < N; i++)
        mapInfo[i][i] = 0;

    for (let mid = 0; mid < N; mid++) {
        for (let start = 0; start < N; start++) {
            for (let end = 0; end < N; end++) {
                if (mapInfo[start][end] > mapInfo[start][mid] + mapInfo[mid][end])
                    mapInfo[start][end] = mapInfo[start][mid] + mapInfo[mid][end];
            }
        }
    }

    for (let i = 0; i < N; i++)
        if (mapInfo[0][i] <= K) answer++;
    return answer;
}