function solution(places) {
  let answer = [];
  const n = places.length; // 대기실 수
  const m = places[0].length;
  let dx = [1, 0, -1, 0];
  let dy = [0, 1, 0, -1];
  for (let w = 0; w < n; w++) {
    // 대기실 수만큼 반복
    let waiting_room = [];
    let flag = false;
    places[w].forEach((ele) => {
      // 문자열들을 2차원 배열로 바꿈
      waiting_room.push(Array.from(ele));
    });
    let wn = waiting_room.length; // n번째 대기실 가로 길이
    let wm = waiting_room[0].length; // n번째 대기실 세로 길이
    for (let i = 0; i < wn; i++) {
      for (let j = 0; j < wm; j++) {
        if (waiting_room[i][j] === "P") {
          for (let k = 0; k <= dx.length; k++) {
            // 4방향 확인
            const nx = i + dx[k];
            const ny = j + dy[k];
            if (nx >= 0 && nx < wn && ny >= 0 && ny < wm) {
              if (waiting_room[nx][ny] === "P") {
                flag = true;
                break;
              }
            }
          }
        } else if (waiting_room[i][j] == "O") {
          let count = 0;
          for (let k = 0; k <= dx.length; k++) {
            if (count >= 2) {
              flag = true;
              break;
            }
            const nx = i + dx[k];
            const ny = j + dy[k];
            if (nx >= 0 && nx < wn && ny >= 0 && ny < wm) {
              if (waiting_room[nx][ny] === "P") {
                count++;
              }
            }
          }
        }
      }
    }
    flag ? answer.push(0) : answer.push(1);
  }

  return answer;
}
