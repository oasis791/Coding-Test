function solution(numbers) {
  numbers.sort((a, b) => {
    cmpA = a.toString() + b.toString();
    cmpB = b.toString() + a.toString();
    return cmpB - cmpA;
  });

  return numbers.every((a) => a === 0) ? "0" : numbers.join("");
}
