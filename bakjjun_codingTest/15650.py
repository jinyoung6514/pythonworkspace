import sys

N, M = map(int,sys.stdin.readline().split())
answer = []
def Dfs(start):
    if len(answer) == M:
        print(" ".join(map(str,answer)))
        return
    for i in range(start,N+1):
        if i not in answer:
            answer.append(i)
            Dfs(i+1)
            answer.pop()
Dfs(1)
