function solution(citations) {
    let maxH = Math.max(...citations);
    for (let h = maxH; h >= 0; h--) {
        let condition1 = citations.filter((count) => h <= count).length >= h;
        let condition2 = citations.filter((count) => h > count).every((count) => count <= h);
        if (condition1 && condition2) return h;
    }
}

console.log(solution([3, 0, 6, 1, 5]));