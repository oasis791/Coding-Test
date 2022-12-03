function solution(want, number, discount) {
  let answer = 0;
  let wants = {};
  let slice = {};
  let count = 0;
  for (let i = 0; i < number.length; i++) {
    wants[want[i]] = number[i];
    slice[want[i]] = 0;
  }
  let slicingNum = number.reduce((a, b) => a + b);
  for (let i = 0; i <= discount.length - slicingNum; i++) {
    let discSlice = Array.from(discount.slice(i, slicingNum + i));
    for (let disc of discSlice) {
      if (want.includes(disc)) {
        slice[disc] = (slice[disc] || 0) + 1;
      }
    }
    for (let wantIndex of want) {
      if (wants[wantIndex] === slice[wantIndex]) {
        count++;
      }
    }
    if (count === want.length) answer++;
    count = 0;

    slice = {};
  }
  return answer;
}
