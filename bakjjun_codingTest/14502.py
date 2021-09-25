import sys
from collections import deque
N,M = map(int,sys.stdin.readline().split())
s = []
max_result = 0
dx = [-1,0,1,0]
dy = [0,1,0,-1]
for i in range(N):
    s.append(list(map(int,sys.stdin.readline().split())))

def bfs():
    global max_result
    copy = [[0]*M for i in range(N)]
    for i in range(N):
        for j in range(M):
            copy[i][j] = s[i][j]
    result = 0
    q = deque([])
    for i in range(N):
        for j in range(M):
            if copy[i][j] == 2:
                q.append([i,j])
    while q:
        a,b = q.popleft()
        for i in range(4):
            x = a+dx[i]
            y = b+dy[i]
            if 0<=x<N and 0<=y<M and copy[x][y] == 0:
                copy[x][y] = 2
                q.append([x,y])
    for i in copy:
        for j in i:
            if j==0:
                result += 1
    max_result = max(max_result,result)

def wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(N):
        for j in range(M):
            if s[i][j] == 0:
                s[i][j] = 1
                wall(cnt+1)
                s[i][j] = 0
wall(0)
print(max_result)