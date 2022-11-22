def solution(a, b, n):
    answer = 0
    while(n >= a):
        cola = (n // a) * b
        answer += cola
        n = (n // a) * b + (n % a)
        
    return answer