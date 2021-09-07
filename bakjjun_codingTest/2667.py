import sys
N = int(sys.stdin.readline())
s = []
for _ in range(N):
    s.append(list(sys.stdin.readline()))
dx = [-1,0,1,0]
dy = [0,1,0,-1]
cnt = 0
apt = []

def dfs(x,y):
    global cnt
    s[x][y] = '0'
    cnt += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= N or ny < 0 or ny >=N:
            continue
        if s[nx][ny] == "1":
            dfs(nx,ny)

for i in range(N):
    for j in range(N):
        if s[i][j] == "1":
            cnt = 0
            dfs(i,j)
            apt.append(cnt)

print(len(apt))
apt.sort()
for i in apt:
    print(i)