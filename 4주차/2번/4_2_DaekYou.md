# [프로그래머스] > 완전탐색 > 카펫
- ```row + col = (brown + 4) // 2```
- 사각형의 최소 크기는 ```3X3```
- ```row = (row + col) - 3  /  col = 3```부터 차례대로 탐색
    - ```(row-2) * (col-2) == yellow```일 경우 조건 만족

```python
def solution(brown, yellow):
    answer = []
    rowPlusColumn = (brown + 4) / 2
    row, col = rowPlusColumn - 3 , 3

    while True:
        estinateYellow = (row-2) * (col-2)
        if yellow == estinateYellow:
            break
        row -= 1
        col += 1

    answer.append(row)
    answer.append(col)
    return answer
```