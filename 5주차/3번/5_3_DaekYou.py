def solution(n, info):
    length = len(info)
    answer = tempAnswer = [0 for _ in range(length)]
    points = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
    maxDifference = 0
    
    
    '''
    - "ezsw"님의 유튜브 해설 강의를 보며 요약하였음
    - 라이언이 이기면 1, 지면 0으로 이루어진 길이 10짜리 비트열의 경우의 수로 검사
    - 10점부터 1점짜리까지 10개로 이루어져 있으니 모든 경우의 수는 2 ^ 10
      - 라이언이 하나도 못 맞춘 경우는 볼 필요가 없으므로 1부터 시작
    - 모든 경우의 수를 돌며, 더 큰 점수 차로 이긴 경우는 따로 저장
    - DP와 비트열을 이용하여 푸신 것 같음
    '''

    for subset in range(1, 1 << (length - 1)):   # 1부터 1023개까지의 경우의 수
        ryanPoint = 0
        apeachPoint = 0
        usedArrowCount = 0
        
        for i in range(length - 1):  # 10점부터 1점까지 차례대로 순회
            if subset & (1 << i):    # 라이언이 이겼을 경우
                ryanPoint += points[i]
                tempAnswer[i] = info[i] + 1
                usedArrowCount += tempAnswer[i]
            else:                    # 라이언이 비기거나 졌을 경우
                tempAnswer[i] = 0
                if info[i]:          # 어피치가 해당 과녁에 맞춘 화살이 1개 이상일 경우
                    apeachPoint += points[i]
        
        if usedArrowCount > n:
            continue
        
        tempAnswer[length - 1] = n - usedArrowCount   # 화살이 남았을 경우, 0점에 모두 기록
        pointDifference = ryanPoint - apeachPoint
        
        if pointDifference == maxDifference:          # 최대차로 이기는 방법이 여러 개 존재하는 경우
            for i in reversed(range(length)):         # 맨 뒤 인덱스부터 탐색
                if tempAnswer[i] > answer[i]:
                    maxDifference = pointDifference
                    answer = tempAnswer.copy()
                    break
                elif tempAnswer[i] < answer[i]:
                    break
                    
        elif pointDifference > maxDifference:
            maxDifference = pointDifference
            answer = tempAnswer.copy()
      
    if maxDifference == 0:
        return [-1]    
    return answer