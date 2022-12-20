# 못 풀었음. 분할 정복으로 깔끔하게 푼 예시 답안이 있길래 가져왔음.

def solution(arr):
    answer = [0, 0]
    n = len(arr)
    
    def quard(x, y, n):
        first = arr[x][y]
        
        for i in range(x, x + n):
            for j in range(y, y + n):
                if arr[i][j] != first:
                    n //= 2
                    quard(x, y, n)
                    quard(x, y + n, n)
                    quard(x + n, y, n)
                    quard(x + n, y + n, n)
                    return
        
        answer[first] += 1
    
    quard(0, 0, n)
        
    return (answer)