import sys
T = int(sys.stdin.readline())
M,N,K,cnt = 0,0,0,0
dx = [-1,0,1,0]
dy = [0,1,0,-1]
visit = []
s = []

def Test():
    global M,N,K,cnt,visit,s
    cnt = 0
    M,N,K = map(int,sys.stdin.readline().split())
    s = [[0]*N for i in range(M)]
    visit = [[0]*N for i in range(M)]

    for _ in range(K):
        a,b = map(int,sys.stdin.readline().split())
        s[a][b] = 1

def result():
    for i in range(M):
        for j in range(N):
            if s[i][j] == 1 and visit[i][j] == 0:
                bfs(i,j)

def bfs(m,n):
    global cnt 
    queue = [[m,n]]
    while queue:
        a,b = queue.pop()
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0<=x<M and 0<=y<N and s[x][y] == 1 and visit[x][y] == 0:
                queue.append([x,y])
                visit[x][y] = 1
    cnt += 1

for i in range(T):
    Test()
    result()
    print(cnt)