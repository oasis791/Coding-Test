# 3진법을 응용하여 풀 수 있을 듯 하다.
'''
# 3으로 나누어 몫이 0이 될 때까지 루프 진행
# 모두 진행했다면 10진법 -> 2진법 변경하듯이 거꾸로 순서대로 나열
    ## 3으로 나누어 떨어지는 경우
    - 나머지 0은 4로 치환
    - 몫은 -1하여 n에 저장 후 다시 루프
    - ex) 30
          30 // 3 = 10...0
          (10-1) // 3 = 3...0
          (3-1) // 3 = 0...2
        
        출력은 200이 나왔으나, 0은 4로 치환하기로 했으므로 답은 244
    
    ## 3으로 나누어 떨어지지 않는 경우
    - 일반적인 3진법 변환 그대로 진행
    - ex) 37
          37 // 3 = 12...1
          12 // 3 = 4...0
          (4-1) // 3 = 1...0
          (1-1) = 0은 무엇으로 나누어도 0이므로 루프 종료
          001 -> 441
'''

def solution(n):
    remainderList = []
    answer = 0
    
    while True:
        if n == 0:
            break
        
        quotient = n // 3      # 몫
        remainder = n % 3      # 나머지
        
        if quotient == 0:
            remainderList.append(remainder)
            break
            
        elif remainder == 0:   # 3으로 나누어 떨어지는 경우
            n = quotient - 1
            remainderList.append(4)
            
        else:
            n = quotient
            remainderList.append(remainder)
            
    return "".join(map(str, reversed(remainderList)))