def solution(n):
    one_count = bin(n).count("1")
    answer = n + 1
    
    while True:
        if one_count == bin(answer).count("1"):
            break
        answer += 1
    
    return answer