def solution(n, a, b):
    answer = 0

    if(a % 2 == 0):
        target1 = [a, a // 2]
    else:
        target1 = [a, a // 2 + 1]
    if (b % 2 == 0):
        target2 = [b, b // 2]
    else:
        target2 = [b, b // 2 + 1]
        
    while True:
        # a, b 가 arr[i][1] 도 같아야하고 arr[a][0] - arr[b][0] 차이도 1이어야 함
        if (abs(target1[0] - target2[0]) == 1 and target1[1] == target2[1]):
            break
        #
        if (target1[0] % 2 == 0):
            target1[0] //= 2

        else:
            target1[0] = target1[0] // 2 + 1
        if (target1[1] % 2 == 0):
            target1[1] //= 2
        else:
            target1[1] = target1[1] // 2 + 1
        if (target2[0] % 2 == 0):
            target2[0] //= 2
        else:
            target2[0] = target2[0] // 2 + 1
        if (target2[1] % 2 == 0):
            target2[1] //= 2
        else:
            target2[1] = target2[1] // 2 + 1
        answer += 1
        
    answer += 1
    return answer