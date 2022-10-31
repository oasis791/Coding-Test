import math
import heapq


def dijkstra(start_node, village_map, N):
    min_heap = []
    distances = [math.inf for _ in range(N + 1)]
    heapq.heappush(min_heap, (0, start_node))
    distances[start_node] = 0
    
    while min_heap:
        distance, now_village = heapq.heappop(min_heap)
        
        # 이미 입력되어 있는 값이 현재 마을까지의 거리보다 작다면 이미 방문한 마을
        if distances[now_village] < distance:
            continue
        
        # 현재 마을과 연결된 모든 마을 탐색
        for village_info in village_map[now_village]:
            alive, cost = village_info
            
            if distance + cost < distances[alive]:
                distances[alive] = distance + cost
                heapq.heappush(min_heap, (distance + cost, alive))
                                                        
    return distances
        

def solution(N, road, K):
    answer = 0
    village_map = [[] for _ in range(N + 1)]
    
    # 초기화
    for info in road:
        start, alive, cost = info[0], info[1], info[2]
        village_map[start].append((alive, cost))
        village_map[alive].append((start, cost))
    
    
    result = dijkstra(1, village_map, N)
    
    for cost in result:
        if cost <= K:
            answer += 1

    return answer