def solution(n):
    answer = []
    field = [[0] * n for _ in range(n)]
    max_number = sum(range(n + 1))
    number = 1
    row, col = -1, 0

    while number <= max_number:
        for _ in range(n):              # 아래로 이동
            row += 1
            
            if field[row][col] == 0:
                field[row][col] = number
                number += 1
            else:
                row -= 1
                break
        
        for _ in range(n - 1):          # 가로로 이동
            col += 1
            if field[row][col] == 0:
                field[row][col] = number
                number += 1
            else:
                col -= 1
                break
        
        for _ in range(n - 2):          # 대각선 이동
            row -= 1
            col -= 1
            if field[row][col] == 0:
                field[row][col] = number
                number += 1
            else:
                row += 1
                col += 1
                break
    
    
    for row in field:
        for number in row:
            if number != 0:
                answer.append(number)
    
    return answer