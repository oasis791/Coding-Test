function solution(fees, records) {
    let parking = new Map();
    let timeLog = new Map();

    function calDuring(record) {
        let start = parking.get(record[1]).split(':').map(Number);
        let end = record[0].split(':').map(Number);
        let during = ((end[0] * 60) + end[1]) - ((start[0] * 60) + start[1]);
        return during;
    }

    function calFee(during) {
        let fee;
        if (during < fees[0]) {
            fee = fees[1];
        } else
            fee = fees[1] + (Math.ceil((during - fees[0]) / fees[2])) * fees[3];
        return fee;
    }

    for (let i = 0; i < records.length; i++) {
        let record = records[i].split(" ");
        if (record[2] === "IN") {
            parking.set(record[1], record[0])
            if (!timeLog.has(record[1]))
                timeLog.set(record[1], 0);
        }
        else {
            let during = calDuring(record);
            timeLog.set(record[1], timeLog.get(record[1]) + during)
            parking.delete(record[1]);
        }
    }

    let arrParking = [...parking]; // [입차시간, 차량번호]

    for (let i = 0; i < arrParking.length; i++) {
        let during = calDuring(["23:59", arrParking[i][0]]);
        timeLog.set(arrParking[i][0], timeLog.get(arrParking[i][0]) + during)
    }

    return [...timeLog].sort((a, b) => a[0] - b[0]).reduce((arr, value) => {
        arr.push(calFee(value[1]));
        return arr;
    }, []);;
}