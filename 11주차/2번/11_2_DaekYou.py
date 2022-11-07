import math
'''
n! // n이 앞 자리 수가 바뀌는 기준의 숫자가 됨
- ex) [1, 2, 3, 4] -> 4! = 24
  24 // 4 = 6

  1             2             3             4             5             6             7
  [1, 2, 3, 4], [1, 2, 4, 3], [1, 3, 2, 4], [1, 3, 4, 2], [1, 4, 2, 3], [1, 4, 3, 2], [2, 1, 3, 4], ...

'''

def solution(n, k):
    people = [i for i in range(1, n + 1)]
    answer = []
    k -= 1

    while n > 0:
        factorial = math.factorial(n)
        split_number = factorial // n
        targetIndex = k // split_number
        answer.append(people[targetIndex])
        people.pop(targetIndex)
        n -= 1
        k %= split_number

    return answer