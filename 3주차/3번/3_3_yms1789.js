function solution(nums) {
  let answer = 0;
  let select = Math.floor(nums.length / 2);
  nums = new Set(nums);
  nums = [...nums];
  if (nums.length > select) {
    return select;
  }
  return nums.length;
}
