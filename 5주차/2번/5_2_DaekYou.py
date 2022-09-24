def solution(n, words):
    preWord = ""
    usedWords = dict()    # 검색에 유리한 Dictionary 사용
    round = 1
    
    for index, word in enumerate(words):
        currentPersonNumber = (index % n) + 1
        
        if index != 0:
            isDuplicated = word in usedWords
            isWrongAnswer = preWord[-1] != word[0]
            
            if isDuplicated or isWrongAnswer:
                return [currentPersonNumber, round]
            
            if currentPersonNumber == n:
                round += 1
        
        usedWords[word] = currentPersonNumber
        preWord = word
    return [0, 0]