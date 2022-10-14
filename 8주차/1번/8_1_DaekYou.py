import re     # 정규표현식 Python 모듈

def solution(dartResult):
    points = list(map(int, re.compile('[0-9]+').findall(dartResult)))
    bonusOptions = re.compile('[SDT][*#]?').findall(dartResult)
    bonusTable = {'S':1, 'D':2, 'T':3}
    currentPoint = 0
    multiplier = 1
    preOption = ''
    
    # 뒤에서부터 검사하며, 스타상(*)이 나오면 그 다음 루프에서 x2를 해주는 방식으로 진행하였음
    points.reverse()
    bonusOptions.reverse()
    
    for point, bonusOption in zip(points, bonusOptions):
        bonus = bonusOption[0]
        option = bonusOption[1] if len(bonusOption) == 2  else None
        calculatedPoint = point ** bonusTable[bonus]

        if preOption == '*':
            multiplier = 4 if option == '*' else 2
        else:
            multiplier = 2 if option == '*' else 1
            
        if option == '#':
            calculatedPoint *= -1
            
        currentPoint += calculatedPoint * multiplier
        preOption = option
    
    return currentPoint