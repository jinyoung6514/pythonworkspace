import sys
N = int(sys.stdin.readline())
distance = list(map(int, sys.stdin.readline().split()))
city = list(map(int,sys.stdin.readline().split()))
cnt = 0
min_value = city[0]
for i in range(N-1):
    if min_value > city[i] :
        min_value = city[i]
    cnt += distance[i] * min_value
print(cnt)