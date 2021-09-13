import sys
from collections import deque
M,N = map(int,sys.stdin.readline().split())
s = []
dx = [-1,0,1,0]
dy = [0,1,0,-1]
queue = deque([]) 
cnt = 0
for i in range(N):
    s.append(list(map(int,sys.stdin.readline().split())))
    for j in range(M):
        if s[i][j] == 1:
            queue.append([i,j])

def bfs():
    while queue:
        a,b = queue.popleft()
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0<=x<N and 0<=y<M and s[x][y] == 0 :
                queue.append([x,y])
                s[x][y] = s[a][b] + 1
bfs()
for i in s:
    for j in i:
        if j == 0:
            print(-1)
            exit()
    cnt = max(cnt,max(i))
print(cnt-1)