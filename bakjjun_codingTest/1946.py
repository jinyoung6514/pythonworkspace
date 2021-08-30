import sys
T = int(sys.stdin.readline())
result = []
for _ in range(T):
    cnt = 1
    num = 0
    N = int(sys.stdin.readline())
    for _ in range(N):
        A,B=map(int,sys.stdin.readline().split())
        result.append((A,B))
    result.sort(key=lambda x:(x[0]))
    num = int(result[0][1])
    for i in result:
        if i[1] < num:
            cnt += 1
            num = i[1]
    print(cnt)
    result.clear()
        