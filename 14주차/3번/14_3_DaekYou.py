from collections import deque

def check_parenthesis(parenthesis):
    stack = []

    for element in parenthesis:
        if element in ['(', '{', '[']:
            stack.append(element)
            continue
        
        if not stack:
            return False
        if stack.pop() + element not in ['()', '{}', '[]']:
            return False
    return len(stack) == 0
            


def solution(s):
    answer = 0
    str_size = len(s)
    
    if str_size % 2 != 0:
        return 0
    
    parenthesis = deque(s)
    
    for x in range(str_size):
        if x != 0:
            parenthesis.rotate(-1)  # 왼쪽으로 한 바퀴 회전
        
        if check_parenthesis(parenthesis):
            answer += 1
    
    return answer