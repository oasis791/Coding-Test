def solution(want, number, discount):
    shopping_basket = dict()
    answer = 0
    length = len(discount) - 9
    
    for i in range(length):
        for j in range(i, i + 10):
            if discount[j] not in shopping_basket:
                shopping_basket[discount[j]] = 1
            else:
                shopping_basket[discount[j]] += 1

                
        have_fisinshed_shopping = True
        
        for key, num in zip(want, number):
            if (key not in shopping_basket) or (shopping_basket[key] < num):
                have_fisinshed_shopping = False
                break
        
        if have_fisinshed_shopping:
            answer += 1
            
        shopping_basket.clear()
        
    return answer