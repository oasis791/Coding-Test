from collections import deque

def solution(skill, skill_trees):
    answer = 0
    skill_length = len(skill)
    
    # 선행 스킬 순서에서 스킬(문자열)을 key, 순서 인덱스를 value로 하여 저장
    trees = {skill:order for order, skill in enumerate(skill)}

    
    for skill_tree in skill_trees:
        current_order = 0
        is_available_tree = True
        
        for skill in skill_tree:
            if skill in trees:
                if current_order < trees[skill]:  # 선행 스킬 트리 순서값보다 크다면 불가능한 스킬트리다.
                    is_available_tree = False
                    break
                    
                else:
                    current_order += 1
            
            if current_order == skill_length:     # 이미 가능한 스킬트리라면 그 뒤 내용까지 볼 필요가 없으므로
                break
        
        if is_available_tree:
            answer += 1
    
    return answer