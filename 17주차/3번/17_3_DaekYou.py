A_area, B_area = 0, 0

def DFS(graph, current, visited, is_A_area):
    visited[current] = True
    
    if is_A_area:
        global A_area
        A_area += 1
    else:
        global B_area
        B_area += 1
    
    for i in graph[current]:
        if not visited[i]:
            DFS(graph, i, visited, is_A_area)
    

def solution(n, wires):
    difference = 1000   # n <= 100 이므로 대충 큰 숫자로
    graph = [[] for _ in range(n + 1)]

    for wire in wires:
        _from, _to = wire
        graph[_from].append(_to)
        graph[_to].append(_from)
    
    for i in range(len(wires)):
        remove_from, remove_to = wires[i][0], wires[i][1]
        
        global A_area
        global B_area
        A_area, B_area = 0, 0
        visited = [False] * (n + 1)
        visited[remove_from] = True
        visited[remove_to] = True
        
        DFS(graph, remove_from, visited, True)
        DFS(graph, remove_to, visited, False)
        
        current_difference = abs(A_area - B_area)
        if current_difference < difference:
            difference = current_difference
    
    return difference
