import sys

N = int(sys.stdin.readline())
number = list(map(int,sys.stdin.readline().split()))
result = [-1]*N
stack = []
for i in range(N-1,-1,-1):
    while stack:
        if stack[-1] <= number[i]:
            stack.pop()
        else:
            break

    if stack:
        result[i] = stack[-1]
    stack.append(number[i])

print(*result)

