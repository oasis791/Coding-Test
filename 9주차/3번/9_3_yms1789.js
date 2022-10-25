function solution(fees, records) {
  // fee[0] = 기본 시간, fees[1] = 기본 요금, fees[2] = 추가 시간, fee[3] = 추가 요금
  let answer = [];
  let parking = new Map();
  let acc = new Map();
  const hourToMin = (time) => {
    let [hour, min] = time.split(":");
    return hour * 60 + +min;
  };
  for (let i = 0; i < records.length; i++) {
    // carInfo: [시간, 차번호, 내역]
    let carInfo = records[i].split(" ");
    if (carInfo[2] === "IN") {
      // 입차
      parking.set(carInfo[1], hourToMin(carInfo[0]));
      if (!acc.has(carInfo[1])) {
        acc.set(carInfo[1], 0);
      }
    }
    if (carInfo[2] === "OUT") {
      // 출차
      let accTime = hourToMin(carInfo[0]) - parking.get(carInfo[1]);
      acc.set(carInfo[1], acc.get(carInfo[1]) + accTime);
      parking.delete(carInfo[1]);
    }
  }
  // parking: {차량번호: 시간}
  if (parking.size > 0) {
    let carNum = Array.from(parking.keys());
    for (let i = 0; i < carNum.length; i++) {
      let accTime = hourToMin("23:59") - parking.get(carNum[i]);
      acc.set(carNum[i], acc.get(carNum[i]) + accTime);
      parking.delete(carNum[i]);
    }
  }

  // fee[0] = 기본 시간, fees[1] = 기본 요금, fees[2] = 단위 시간, fee[3] = 단위 요금
  // acc: {차: 누적 시간}
  for (let [carNum, time] of acc) {
    fees[0] >= time
      ? (time = fees[1])
      : (time = fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3]);
    answer.push([carNum, time]);
  }
  return answer.sort((a, b) => a[0] - b[0]).map((ele) => ele[1]);
}