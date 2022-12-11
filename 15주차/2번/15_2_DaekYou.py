import math

def solution(k, d):
    answer = 0
    
    for x in range(0, d + 1, k):
        y_max = int(math.sqrt((d ** 2) - (x ** 2)))
        point_nums = (y_max // k) + 1
        answer += point_nums
    
    return answer
    