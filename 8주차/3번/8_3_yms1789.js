function solution(cacheSize, cities) {
  let answer = 0;
  let cache = Array(cacheSize);
  cities = cities.map((ele) => ele.toLowerCase());
  for (let i = 0; i < cities.length; i++) {
    if (cacheSize <= 0) {
      answer = 5 * cities.length;
      break;
    }
    if (cache.includes(cities[i])) {
      cache.splice(cache.indexOf(cities[i]), 1);
      cache.push(cities[i]);
      answer += 1;
      continue;
    }
    if (cache.length >= cacheSize) {
      cache.shift();
      cache.push(cities[i]);
      answer += 5;
      continue;
    }
    cache.push(cities[i]);
    answer++;
  }
  return answer;
}
