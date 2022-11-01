function solution(n) {
    let nBinaryOneLen = n.toString(2).replaceAll('0', '').length;
    let nextNum = n + 1;
    while (true) {
        let nextNumBinaryOneLen = nextNum.toString(2).replaceAll('0', '').length;
        if (nextNumBinaryOneLen === nBinaryOneLen)
            return nextNum;
        else
            nextNum++;
    }
}