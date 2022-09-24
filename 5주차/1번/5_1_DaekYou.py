import sys
# 서류 성적과 면접 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발

input = sys.stdin.readline
T = int(input())      # 1 <= T <= 20
applicants = []

for _ in range(T):
    N = int(input())  # 1 <= N <= 100,000
    applicants.clear()
    result = 1
    
    for _ in range(N):
        documentRank, interviewRank = map(int, input().split())
        applicants.append((documentRank, interviewRank))

    applicants.sort(key = lambda x: x[0])                       # 서류 심사 성적에 대하여 오름차순 정렬
    pivot = applicants[0][1]
    
    for i in range(1, N):                                       # 면접 심사 기록이 이전 사람보다 좋을 경우 선발
        if applicants[i][1] < pivot:
            pivot = applicants[i][1]
            result += 1
    print(result)