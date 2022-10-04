class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            func(n % 3, sb);
            if (n % 3 == 0) {
                n = n / 3 - 1;
            } else {
                n /= 3;
            }
        }
        return sb.toString();
    }

    static StringBuilder func(int n, StringBuilder sb) {
        switch (n) {
            case 1 -> sb.insert(0, 1);
            case 2 -> sb.insert(0, 2);
            case 0 -> sb.insert(0, 4);
        }
        return sb;
    }
} 
