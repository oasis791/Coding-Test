class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int[] number) {

        visited = new boolean[number.length];

        for (int i = 0; i < number.length; i++) {
            visited[i] = true;
            func(i, 1, number[i], number);
            visited[i] = false;
        }

        return answer;
    }

    void func(int start, int cnt,  int result, int[] number) {
        if(cnt == 3){
            if (result == 0) {
                answer++;
            }
            return;
        }

        for (int i = start + 1; i < number.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                func(i,cnt + 1, result + number[i], number);
                visited[i] = false;
            }
        }
    }
}