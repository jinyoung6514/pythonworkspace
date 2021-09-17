import sys
from collections import deque
dx = [-1,-1,0,1,1,1,0,-1]
dy = [0,1,1,1,0,-1,-1,-1]

def bfs(k1,k2):
    q = deque([])
    q.append([k1,k2])
    s[k1][k2] = 0
    while q:
        a,b = q.popleft()
        for i in range(8):
            x = a + dx[i]
            y = b + dy[i]
            if 0<=x<h and 0<=y<w and s[x][y] == 1:
                q.append([x,y])
                s[x][y] = 0

while True:
    w,h = map(int,sys.stdin.readline().split())
    s= []
    cnt = 0
    if w == 0 and h == 0:
        break
    for _ in range(h):
        s.append(list(map(int,sys.stdin.readline().split())))
    for i in range(h):
        for j in range(w):
            if s[i][j] == 1:
                bfs(i,j)
                cnt+=1
    print(cnt)