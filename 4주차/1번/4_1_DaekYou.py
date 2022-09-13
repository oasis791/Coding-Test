def solution(s):
    words = s.split(' ')
    answer = ''

    for word in words:
        word = word.lower()
        chars = list(word)   #Python에서 문자열은 immutable
        length = len(chars)
            
        for index in range(length):
            isEven = (index == 0) or (index % 2 == 0) 
            if isEven:
                answer += chars[index].upper()
            else:
                 answer += chars[index]
        answer += ' '
    return answer[:-1]