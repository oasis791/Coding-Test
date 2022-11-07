import math
'''
모두 1로 점프한 걸 제외한 다음부터는 n - 1을 하며, 2의 개수를 1개씩 늘려 조합의 수를 구하는 것과 같다.

ex) 5의 경우,
11111
------- 4C1
2111
1211
1121
1112
------- 4C2
221
212
122
'''

def solution(n):
    answer = 1
    half = n // 2
    
    for i in range(1, half + 1):
        n -= 1
        answer += math.comb(n, i)
        
    return answer % 1234567
