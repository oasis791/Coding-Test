answer = 0

def DFS(playerFatigue, count, dungeons, visited):
    global answer
    
    if answer < count:
        answer = count
    
    for i in range(len(dungeons)):
        minRequiredFatigue = dungeons[i][0]
        requiredFatigue = dungeons[i][1]
    
        if playerFatigue >= minRequiredFatigue and not visited[i]:
            visited[i] = True
            DFS(playerFatigue - requiredFatigue, count + 1, dungeons, visited)
            visited[i] = False

def solution(k, dungeons):
    global answer        
    dungeons.sort(reverse = True)
    visited = [False for _ in range(len(dungeons))]
    
    DFS(k, 0, dungeons, visited)
    
    return answer