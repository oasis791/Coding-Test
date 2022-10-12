function solution(cacheSize, cities) {
    let answer = 0;
    let cache = new Set();
    cities = cities.map((v) => v.toLowerCase());
    for (let city of cities) {
        if (!cache.has(city)) { // cache miss
            if (cache.size === cacheSize)
                cache.delete([...cache].at(0));
            if (cacheSize > 0)
                cache.add(city);
            answer += 5;
        }
        else { // cache hit
            cache.delete(city);
            cache.add(city);
            answer += 1;
        }
    }
    return answer;
}