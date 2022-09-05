import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int amount = nums.length / 2;
        int[] newNum = Arrays.stream(nums).distinct().toArray();
        if (newNum.length >= amount) {
            return amount;
        }
        return newNum.length;
    }
}
