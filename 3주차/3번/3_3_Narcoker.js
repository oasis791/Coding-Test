// [프로그래머스] 폰켓몬
function solution(nums) {
    let count = [...new Set(nums)].length;
    let monster_max = nums.length / 2;
    return count > monster_max ? monster_max : count;
}