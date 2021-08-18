import sys
N = int(sys.stdin.readline())
# 배열의 길이가 10001인 list를 미리 선언
result = [0 for _ in range(10001)]
for _ in range(N):
    x = int(sys.stdin.readline())
    result[x] += 1
for i in range(len(result)):
    for j in range(result[i]):
        print(i)