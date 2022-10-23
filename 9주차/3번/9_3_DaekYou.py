import math

def solution(fees, records):
    defaultTimeMinute, defaultFee, unitTimeMinute, unitFee = fees[0], fees[1], fees[2], fees[3]
    recordTable = dict()
    answer = []
    
    for record in records:
        time, carNumber, breakdown = record.split(' ')
        minuteTime = 60 * int(time[:2]) + int(time[3:])         # 분 단위로 바꾸어 가지고 있음
        
        if carNumber not in recordTable:
            recordTable[carNumber] = [minuteTime, 0, 'IN']      # 현재 시각, 총 주차 시간, 내역
            continue
        
        parkingRecord = recordTable[carNumber]
        
        if breakdown == 'OUT':
            parkingRecord[1] += minuteTime - parkingRecord[0]
            parkingRecord[0] = 0
            parkingRecord[2] = 'OUT'
        
        elif breakdown == 'IN':
            parkingRecord[0] = minuteTime
            parkingRecord[2] = 'IN'
    
    
    # 오늘 출차를 안 한 차량들 23:59까지 주차한 것으로 계산
    endMinuteTime = 60 * 23 + 59
    
    for carNumber, record in recordTable.items():
        if record[2] == 'IN':
            recordTable[carNumber][1] += (endMinuteTime - record[0])
    
    tableKeys = list(recordTable.keys())
    tableKeys.sort()
    
    
    for key in tableKeys:
        isOverDefaultTime = 1 if recordTable[key][1] >= defaultTimeMinute else 0
        fee = defaultFee + isOverDefaultTime * (math.ceil((recordTable[key][1] - defaultTimeMinute) / unitTimeMinute) * unitFee)
        answer.append(fee)
    
    return answer