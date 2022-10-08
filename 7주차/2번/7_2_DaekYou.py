def solution(msg):
    answer = []
    upper_A_ord = ord('A')
    messageDictionary = dict()
    
    # 길이가 1인 모든 영문 대문자 초기화
    for i in range(26):
        messageDictionary[chr(upper_A_ord + i)] = i + 1

    end = len(messageDictionary)
    length = len(msg)
    i = 0
    n_gram = []
    preString = ''
    
    
    while i < length:
        n_gram.append(msg[i])
        targetString = ''.join(n_gram)
        
        if targetString in messageDictionary:
            preString = targetString
        else:
            answer.append(messageDictionary[preString])
            messageDictionary[targetString] = end + 1
            end += 1
            n_gram.clear()
            i -= 1     # 새로 등록한 마지막 글자를 다음 루프에서 n_gram에 넣기 위해 한 칸 뒤로
        i += 1
        
    answer.append(messageDictionary[preString]) # 루프가 끝나서 처리되지 않은 나머지 문자 처리
    return answer