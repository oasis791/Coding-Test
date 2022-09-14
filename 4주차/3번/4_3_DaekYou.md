# BOJ-11404 | 플로이드
## 풀이 전략
1. 굉장히 큰 수로 이루어진 ```n X n``` 2차원 리스트를 생성
2. A도시에서 B도시로 가는 비용을 2차원 리스트에 입력
    - A 도시에서 B 도시로 가는 버스 노선은 여러 개가 있을 수 있으므로 그 중 가장 비용이 적은 것을 선택
3. 플로이드 알고리즘 동작 시작
    - 자기 자신에게 가는 노선은 없으므로 0 처리
    - 기존 노선 비용과 경유지로 돌아가는 노선 비용 중 작은 것을 선택 -> 도시 개수만큼 알고리즘 작동
4. 출력
    - 갈 수 없는 도시의 경우에는 0 출력
    - 아니라면 계산했던 비용 출력  
    

## 소스코드
```python
import sys
input = sys.stdin.readline

n = int(input())          # 도시의 개수 (2이상 100 이하)
m = int(input())          # 버스 개수 (1 이상 100,000 이하)
costTable = [[sys.maxsize] * n for _ in range(n)]  # 2차원 리스트 만들기

for _ in range(m):        # 시작 도시에서 도착 도시로 가는 여러 노선 중 가장 작은 비용 노선 선택
    startCity, aliveCity, cost = map(int, input().split())
    costTable[startCity - 1][aliveCity - 1] = min(costTable[startCity - 1][aliveCity - 1], cost)

for wayPoint in range(n):
    costTable[wayPoint][wayPoint] = 0   # 자기 자신에게 가는 노선은 없으므로 0 처리
    
    for startCity in range(n):
        for aliveCity in range(n):
            originalRouteCost = costTable[startCity][aliveCity]
            wayPointRouteCost = costTable[startCity][wayPoint] + costTable[wayPoint][aliveCity]
            costTable[startCity][aliveCity] = min(originalRouteCost, wayPointRouteCost)

for costs in costTable:
    for cost in costs:
        if cost == sys.maxsize:
            print(0, end = ' ')
        else:
            print(cost, end = ' ')
    print()
```