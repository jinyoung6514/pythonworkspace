# input을 사용하면 시간초과가 되니 split을 사용할 것

import sys

N = int(sys.stdin.readline())

stack = []

for a in range(N):
    input = sys.stdin.readline().split()

    if input[0] == "push":
        stack.append(int(input[1]))
    elif input[0] == "pop":
        if len(stack) == 0:
            print(-1)
        else :
            print(stack[-1])
            stack.pop()
    elif input[0] == "size":
        print(len(stack))
    elif input[0] == "empty":
        if len(stack) == 0:
            print(1)
        else :
            print(0)
    elif input[0] == "top":
        if len(stack) == 0:
            print(-1)
        else :
            print(stack[-1])
        
    