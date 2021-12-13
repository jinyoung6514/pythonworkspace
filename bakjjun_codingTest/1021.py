import sys
from collections import deque
N,M = map(int,sys.stdin.readline().split())
q = deque([i for i in range(1,N+1)])
num = list(map(int,sys.stdin.readline().split()))
cnt = 0
for i in num:
    while True:
        if q[0] == i:
            q.popleft()
            break
        else:
            if q.index(i) < len(q)/2:
                while q[0] != i:
                    q.append(q.popleft())
                    cnt+=1
            else:
                while q[0] != i:
                    q.appendleft(q.pop())
                    cnt+=1
print(cnt)