from collections import deque

def solution(queue1, queue2):
    answer = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)
    
    queue1_len = len(queue1)
    queue2_len = len(queue2)
    
    max_loop_count = (queue1_len + queue2_len) * 2
    
    if(queue1_sum + queue2_sum) % 2 == 1:
        return -1
    
    loop_count = 0
    while queue1_sum != queue2_sum:
        if (loop_count > max_loop_count) or (queue1_len <= 0 or queue2_len <= 0):
            answer = -1
            break
        
        if queue1_sum < queue2_sum:
            element = queue2.popleft()
            queue2_sum -= element
            queue2_len -= 1

            queue1.append(element)
            queue1_sum += element
            queue1_len += 1
            answer += 1
        
        elif queue1_sum > queue2_sum:
            element = queue1.popleft()
            queue1_sum -= element
            queue1_len -= 1
            
            queue2.append(element)
            queue2_sum += element
            queue2_len += 1
            answer += 1
        
        loop_count += 1
        
    return answer