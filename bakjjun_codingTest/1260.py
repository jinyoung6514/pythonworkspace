import sys
from collections import deque
N, M, V = map(int,sys.stdin.readline().split())
s = [[0]*N for i in range(N)]
dfs_visit = [0 for i in range(N)]
bfs_visit = [0 for i in range(N)]
q = deque()

for i in range(M):
    a,b = map(int,sys.stdin.readline().split())
    s[a-1][b-1] = 1
    s[b-1][a-1] = 1

def dfs(v):
    dfs_visit[v] = 1
    print(v+1,end=" ")
    for i in range(N):
        if s[v][i] == 1 and dfs_visit[i] == 0:
            dfs(i)

def bfs(v):
    q.append(v)
    bfs_visit[v] = 1
    while q:
        x = q.popleft()
        print(x+1, end=" ")
        for i in range(N):
            if s[x][i] == 1 and  bfs_visit[i] == 0:
                q.append(i)
                bfs_visit[i] = 1

dfs(V-1)
print()
bfs(V-1)