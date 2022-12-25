from itertools import combinations


def find_unique_keys(relation):
    tuple_nums = len(relation)
    column_nums = len(relation[0])
    _combination = []
    
    for i in range(1, column_nums + 1):
        _combination += combinations(range(column_nums), i)

    unique_keys = []
    for combi in _combination:
        data = [tuple([row[index] for index in combi]) for row in relation]
        
        if len(set(data)) == tuple_nums:
            unique_keys.append(combi)
    
    return unique_keys


def filtering_minimality(unique_keys):
    length = len(unique_keys)
    candidate_keys = set(unique_keys)
    
    for i in range(length):
        for j in range(i + 1, length):
            if set(unique_keys[i]).issubset(set(unique_keys[j])):  # 부분집합이라면 최소성 만족 X
                candidate_keys.discard(unique_keys[j])
    
    return candidate_keys


def solution(relation):
    unique_keys = find_unique_keys(relation)
    candidate_keys = filtering_minimality(unique_keys)
    
    return len(candidate_keys)
    