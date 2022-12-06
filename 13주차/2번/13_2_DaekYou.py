from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    combi_list = []
    
    for course_num in course:
        for order in orders:
            combi_list += combinations(sorted(order), course_num)
        
        # 최빈값 빈도를 리스트에 담긴 튜플 형태(key, value)로 반환 큰 순서대로 반환
        favorite_orders = Counter(combi_list).most_common()
        answer += [key for key, value in favorite_orders if value > 1 and value == favorite_orders[0][1]]
        combi_list.clear()
        
    return ["".join(value) for value in sorted(answer)]