from itertools import combinations

def find_intersection(A, B, E, C, D, F):
    denominator = A*D - B*C
    
    if denominator == 0:
        return (None, None)
    
    x = (B*F - E*D) / denominator
    y = (E*C - A*F) / denominator
    return (x, y)



def solution(line):
    intersections = set()   # 중복된 교점 제거를 위해
    x_points, y_points = set(), set()
    data = combinations(line, 2)
    
    for line1, line2 in data:
        A, B, E = line1
        C, D, F = line2
        x, y = find_intersection(A, B, E, C, D, F)
        
        if x != None and y != None:
            if x.is_integer() and y.is_integer():
                intersections.add((int(x), int(y)))
                x_points.add(int(x))
                y_points.add(int(y))
    
    left_edge_x, right_edge_x = min(x_points), max(x_points)
    up_edge_y, down_edge_y = max(y_points), min(y_points)
    
    answer = [['.'] * (right_edge_x - left_edge_x + 1) for _ in range(up_edge_y - down_edge_y + 1)]
    
    for x, y in intersections:
        answer[up_edge_y - y][x - left_edge_x] = '*'
    
    return list(map("".join, answer))
