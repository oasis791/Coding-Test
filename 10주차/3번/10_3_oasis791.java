class Solution {
    public int solution(int n) {
        int target = Integer.bitCount(n);
        while (true) {
            n++;
            if (Integer.bitCount(n) == target)
                return n;
        }
    }
}
