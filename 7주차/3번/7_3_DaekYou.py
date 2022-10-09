def ExtractTupleAndReturnSet(tupleString):
    decimalStringList = []
    setElements = []
    tupleSets = []
    onExtract = False
    
    for char in tupleString:
        if char == '{':
            onExtract = True
            continue
        
        if char.isdigit():
            decimalStringList.append(char)
            continue
        
        if char == ',' and onExtract:    # {} 안에 있는 ','일 때만 
            setElements.append(int(''.join(decimalStringList)))
            decimalStringList.clear()
            
        elif char == '}':
            setElements.append(int(''.join(decimalStringList)))
            tupleSets.append(set(setElements))
            onExtract = False
            decimalStringList.clear()
            setElements.clear()
    
    return tupleSets
    

# 정규식으로 푸신 분의 풀이를 봤다. 대단하다... 그런 생각을 하다니
# 너무 허접한데 내 코드ㄷㄷ
def solution(s):
    tupleString = s[1:-1]                     # 양 옆 {} 제외
    tupleSets = ExtractTupleAndReturnSet(tupleString)    # 문자열에서 튜플 쌍 리스트 추출
    tupleSets.sort(key = len)                    # 개수별로 오름차순 정렬
    preSet = set() 
    answer = []

    for _set in tupleSets:
        temp = _set - preSet
        for element in temp:
            answer.append(element)
            preSet = _set

    return answer