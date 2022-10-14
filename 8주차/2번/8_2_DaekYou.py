from collections import deque
from collections import Counter

def solution(priorities, location):
    queue = deque()
    counters = Counter(priorities)
    answer = 0
    maxPriority = max(priorities)
    
    for index, priority in enumerate(priorities):
        isTarget = True if index == location else False
        queue.append((priority, isTarget))
    
    
    while queue:
        document = queue.popleft()
        hasHigherPriority = False
        
        for i in range(document[0] + 1, maxPriority + 1):  # 자기보다 우선순위가 높은 문서가 있는지 확인
            if counters[i] > 0:
                queue.append(document)
                hasHigherPriority = True
                break
        
        if hasHigherPriority:  # 있다면 다음 루프로
            continue
        
        # 여기까지 왔으면 없다는 것이므로 출력하고 카운트 1개 차감
        answer += 1
        counters[document[0]] -= 1
        
        # 만약 찾고자 하던 문서였다면 break
        if document[1]:
            break
    
    return answer