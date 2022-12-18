from collections import Counter

def categorize(cards):
    labels = [0 for _ in range(len(cards))]
    category_num = 1
    
    for card_num in cards:
        target_idx = card_num - 1
        
        while labels[target_idx] == 0:
            labels[target_idx] = category_num
            target_idx = cards[target_idx] - 1
            
        category_num += 1
    
    return labels


def solution(cards):
    labels = categorize(cards)
    categories = Counter(labels).most_common(2)
    
    if len(categories) == 1:
        return 0
    return categories[0][1] * categories[1][1]