import sys
from collections import deque
N,M,V = map(int,sys.stdin.readline().split())

visit = [0] * (N+1)
graph = [0][0]
def bfs(V):
    q = deque()
    q.append(V)
    visit[V] = 1
    while q:
        V = q.popleft()
        print(V, end=" ")
        for i in range(1,N+1):
            if visit[i] == 0 and graph[V][i] == 1:
                q.append[i]
                visit[i] = 1

def dfs():
    pass

for _ in range(M):
    pass
