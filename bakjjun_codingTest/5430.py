import sys
from collections import deque

T = int(sys.stdin.readline())
for _ in range(T):
    left = 0
    p = sys.stdin.readline().rstrip()
    n = int(sys.stdin.readline())
    tc = deque(sys.stdin.readline().rstrip()[1:-1].split(','))
    for i in p:
        if n == -1:
            break
        if i == "R":
            left+=1
        else:
            if tc:
                if left %2 == 1:
                    tc.pop()
                else:
                    tc.popleft()
            n -=1
    if n == -1:
        print("error")
    else:
        if left % 2 == 1:
            tc.reverse()
        print("["+",".join(tc)+"]")
