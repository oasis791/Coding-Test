function solution(arrayA, arrayB) {
  let answer = 0;
  function gcd(a, b) {
    while (b > 0) {
      let r = a % b;
      a = b;
      b = r;
    }
    return a;
  }
  function arrGcd(arr) {
    let num = arr[0];
    for (let item of arr) {
      num = gcd(num, item);
    }
    return num;
  }
  let Agcd = arrGcd(arrayA);
  let Bgcd = arrGcd(arrayB);

  let isDivBgcdToA = arrayA.every((ele) => ele % Bgcd !== 0);
  let isDivAgcdToB = arrayB.every((ele) => ele % Agcd !== 0);

  if (isDivBgcdToA && isDivAgcdToB) {
    answer = Math.max(Agcd, Bgcd);
  } else if (isDivBgcdToA === false && isDivAgcdToB) {
    answer = Agcd;
  } else if (isDivAgcdToB === false && isDivBgcdToA) {
    answer = Bgcd;
  } else {
    answer = 0;
  }
  return answer;
}
