import sys
sys.setrecursionlimit(100000)

n = int(sys.stdin.readline())
dx = [-1,0,1,0]
dy = [0,1,0,-1]
s= []
max_cnt = 1
for _ in range(n):
    s.append(list(map(int, sys.stdin.readline().split())))

def dfs(a,b,k):
    for i in range(4):
        x = a+dx[i]
        y = b+dy[i]
        if 0<=x<n and 0<=y<n and not visit[x][y] and s[x][y] > k:
            visit[x][y] =  True
            dfs(x,y,k)

for k in range(1,101):
    cnt = 0
    visit = [[False]*n for i in range(n)]
    for i in range(n):
        for j in range(n):
            if s[i][j] > k and not visit[i][j]:
                visit[i][j] = True
                dfs(i,j,k)
                cnt += 1
    if cnt == 0:
        print(max_cnt)
        break
    max_cnt = max(max_cnt,cnt)