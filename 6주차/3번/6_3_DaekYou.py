def solution(survey, choices):
    points = [None, 3, 2, 1, 0, 1, 2, 3]   # 편하게 인덱싱하기 위해
    indicator = ["RT", "CF", "JM", "AN"]
    pointTable = {"R":0, "T":0, "C":0, "F":0, "J":0, "M":0, "A":0, "N":0}
    answer = []
    
    for types, choice in zip(survey, choices):
        disagreeType, agreeType = types[0], types[1]

        if choice >= 1 and choice < 4:
            pointTable[disagreeType] += points[choice]
        elif choice > 4 and choice <= 7:
            pointTable[agreeType] += points[choice]
    
    for types in indicator:
        type_1, type_2 = types[0], types[1]
        
        if pointTable[type_1] > pointTable[type_2]:
            answer.append(type_1)
        elif pointTable[type_1] < pointTable[type_2]:
            answer.append(type_2)
        elif pointTable[type_1] == pointTable[type_2]:
            if ord(type_1) < ord(type_2):
                answer.append(type_1)
                continue
            answer.append(type_2)
    
    return "".join(answer)