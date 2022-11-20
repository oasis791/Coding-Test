def solution(a, b, n):
    remainedCokeBottles = 0
    receivedCokes = 0
    answer = 0
    
    while n >= a:
        receivedCokes = (n // a) * b    # 교환받은 콜라 수
        answer += receivedCokes
        remainedCokeBottles = n % a     # 가지고 있는 남은 빈병 수
        n = receivedCokes + remainedCokeBottles
    return answer