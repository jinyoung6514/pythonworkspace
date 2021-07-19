import sys
asd
N = int(sys.stdin.readline())

Queue = []

for i in range(N):
    input = sys.stdin.readline().split()
    
    if input[0] == "push":
        Queue.append(input[1])
    elif input[0] == "pop":
        if len(Queue) == 0:
            print(-1)
        else :
            print(Queue[0])
            del Queue[0]
    elif input[0] == "size":
        print(len(Queue))
    elif input[0] == "empty":
        if len(Queue) == 0:
            print(1)
        else:
            print(0)
    elif input[0] == "front":
        if len(Queue) == 0:
            print(-1)
        else:
            print(Queue[0])
    elif input[0] == "back":
        if len(Queue) == 0:
            print(-1)
        else:
            print(Queue[-1])
