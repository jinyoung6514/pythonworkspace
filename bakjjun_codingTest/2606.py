import sys
com = int(sys.stdin.readline())
virus = int(sys.stdin.readline())
s = [[0] * com for i in range(com)]
visit = [0 for i in range(com)]
for _ in range(virus):
    a,b = map(int,sys.stdin.readline().split())
    s[a-1][b-1] = 1
    s[b-1][a-1] = 1
def dfs(v):
    visit[v] = 1
    for i in range(com):
        if s[v][i] == 1 and visit[i] == 0:
            dfs(i)
dfs(0)
cnt = 0
for i in range(1,com):
    if visit[i] == 1:
        cnt += 1
print(cnt)