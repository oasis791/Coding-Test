from collections import deque

def solution(cacheSize, cities):
    cache = deque(maxlen = cacheSize)    # 최대 개수일 때 새로운 데이터를 추가하면, 가장 오래된 데이터를 버리고 새로운 데이터를 뒤에 새로 추가
    answer = 0
    
    for city in cities:
        city = city.lower()
        
        if city not in cache:
            cache.append(city)
            answer += 5
        
        else:
            cache.remove(city)
            cache.append(city)
            answer += 1
    
    return answer