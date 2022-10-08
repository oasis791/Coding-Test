def solution(lottos, win_nums):
  prizeTable = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
  correctNums = 0
  unknownNums = 0
  answer = []
  
  # 맞춘 번호 개수와 모르는 번호 개수 세기
  for number in lottos:
    if number == 0:
      unknownNums += 1

    elif number in win_nums:
      correctNums += 1

  maxRank = prizeTable[correctNums + unknownNums]
  minRank = prizeTable[correctNums]
  
  answer.append(maxRank)
  answer.append(minRank)
    
  return answer

