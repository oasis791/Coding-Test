def solution(number):
    answer = 0
    length = len(number)
    
    for i in range(length - 2):
        for j in range(i + 1, length - 1):
            for k in range(j + 1, length):
                if number[i] + number[j] + number[k] == 0:
                    answer += 1
    return answer