def GCD(x, y):
    while y:
        x, y = y, x % y
    return x

def LCM(x, y):
    result = (x * y) // GCD(x, y)
    return result

def solution(arr):
    answer = arr[0]
    for num in arr[1:]:
        answer = LCM(answer, num)
    return answer