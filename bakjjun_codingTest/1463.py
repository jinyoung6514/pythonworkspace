# 3으로 나눌때랑 2로나눌때랑 경우의 수를 다따져보고 그 자리에 대한 최솟값을 구해야함
# 미리 자릿수를 다 만들어놓고 그 전 자리수와 2,3으로 나눠서 모든 경우의 수를 비교해야함

import sys
N = int(sys.stdin.readline())
d = [0] * (N+1)
for i in range(2,N+1):
    d[i] = d[i-1] + 1
    if i % 3 ==0:
        d[i] = min(d[i],d[i//3]+1)
    if i % 2 ==0:
        d[i] = min(d[i],d[i//2]+1)
print(d[N])
