import sys
from collections import deque
N, K = map(int,sys.stdin.readline().split())
MAX = 100001
time = [0]*MAX

def bfs():
    q = deque()
    q.append(N)
    while q:
        v = q.popleft()
        if v== K:
            print(time[v])
            return
        for i in (v-1,v+1,v*2):
            if 0<= i < MAX and not time[i]:
                time[i] = time[v] + 1
                q.append(i)
bfs()