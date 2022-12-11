from collections import Counter

def solution(k, tangerine):
    answer = 0
    extraction_count = 0  # 추출 개수
    counter = Counter(tangerine).most_common(k)  # 빈도가 높은 순으로 k개 추출
    
    for size, count in counter:
        extraction_count += count
        answer += 1
        if extraction_count >= k:
            break
    
    return answer
    