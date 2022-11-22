function solution(numbers) {
  let answer = 0;
  function permutation(arr, selectNum) {
    let result = [];
    if (selectNum === 1) return arr.map((v) => [v]);

    arr.forEach((v, idx, arr) => {
      const fixer = v;
      const restArr = arr.filter((_, index) => index !== idx);
      const permuationArr = permutation(restArr, selectNum - 1);
      const combineFixer = permuationArr.map((v) => [fixer, ...v]);
      result.push(...combineFixer);
    });
    return result;
  }

  let numberList = [];
  const isPrime = (num) => {
    if (num <= 1) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) return false;
    }
    return true;
  };
  for (let i = 1; i <= numbers.length; i++) {
    const arr = Array.from(numbers);
    numberList.push(permutation(arr, i));
  }
  numberList = numberList.flat();
  let setNumber = [];
  for (ele of numberList) {
    setNumber.push(Number(ele.join("")));
  }
  setNumber = [...new Set(setNumber)];
  setNumber = setNumber.filter((ele) => isPrime(ele) === true);
  console.log(setNumber.sort((a, b) => a - b));
  return setNumber.length;
}
