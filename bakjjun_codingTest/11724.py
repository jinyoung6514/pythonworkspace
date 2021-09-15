import sys
sys.setrecursionlimit(10000)
N, M = map(int,sys.stdin.readline().split())
s = [[0]*N for i in range(N)]
visit = [0 for i in range(N)]
cnt = 0
for _ in range(M):
    u,v = map(int,sys.stdin.readline().split())
    s[u-1][v-1] = 1
    s[v-1][u-1] = 1

def dfs(v):
   visit[v] = 1 
   for i in range(N):
       if s[v][i] == 1 and visit[i] == 0:
           dfs(i)
           
for i in range(N):
    if visit[i] == 0:
        dfs(i)
        cnt+=1
print(cnt)