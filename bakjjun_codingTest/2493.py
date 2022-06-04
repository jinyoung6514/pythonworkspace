import sys
N = int(sys.stdin.readline())

result = [0] * N
stack = []
top = list(map(int,sys.stdin.readline().split()))

for i in range(N):
    while stack:
        if stack[-1][1]>top[i]:
            break
        else:
            stack.pop()
    if stack:
        result[i] = stack[-1][0] + 1
    stack.append([i,top[i]]) 

for i in result:
    print(i,end=" ")