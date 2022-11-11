function solution(numbers) {
    let answer = 0;
    let isSelected = Array(numbers.length).fill(false);
    let numberLog = new Set();
    numbers = numbers.split('');
    ;
    function checkPrimeNumber(number) {
        if (number < 2) return;

        let maxNumber = Math.floor(Math.sqrt(number));
        for (let i = 2; i <= maxNumber; i++)
            if (number % i === 0) return;

        answer++;
    }

    function makeNumber(numberString, isSelected, count) {
        if (count > numbers.length) return;

        for (let i = 0; i < numbers.length; i++) {
            if (!isSelected[i]) {
                let newNumber = Number(numberString + numbers[i]);

                if (!numberLog.has(newNumber)) {
                    numberLog.add(newNumber);

                    checkPrimeNumber(Number(newNumber));
                }

                let newIsSelected = [...isSelected];
                newIsSelected[i] = true;
                makeNumber(numberString + numbers[i], newIsSelected, count + 1);
            }
        }
    }

    makeNumber("", isSelected, 0);
    return answer;

}