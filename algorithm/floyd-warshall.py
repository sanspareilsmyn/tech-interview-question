# Floyd Warshall 알고리즘
# 최단경로 알고리즘
# 다익스트라는 하나의 정점에서 다른 모든 정점의 최단 경로를 구하는 알고리즘이라면,
# 플로이드 와샬 알고리즘은 모든 정점에서 모든 정점으로의 최단 경로를 구하는 알고리즘
# X에서 Y로 가는 비용 vs (X에서 a 가는 비용 + a에서 Y 가는 비용)

# 백준 11404
import sys
n = int(input()) # 도시의 개수
m = int(input()) # 간선의 개수
cost = [[100001 for _ in range(n+1)] for _ in range(n+1)]

# 초기화
for _ in range(m):
    start, end, c = map(int, input().split())
    cost[start][end] = min(c, cost[start][end])

# Floyd-Warshall
for k in range(1, n+1): # 경로
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i == j:
                cost[i][j] = 0
            else:
                cost[i][j] = min(cost[i][j], cost[i][k] + cost[k][j])

for y in cost[1:]:
    for x in y[1:]:
        if x == 100001:
            print(0, end = " ")
        else:
            print(x, end = " ")
    print()