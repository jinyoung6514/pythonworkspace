import sys
N,K = map(int,sys.stdin.readline().split())
value = []
num = 0
for _ in range(N):
    x = int(sys.stdin.readline())
    value.append(x)
for i in range(N-1,-1,-1):
    if K==0:
        break
    if value[i] > K:
        continue
    num += int(K/value[i])
    K = K % value[i] 
print(num)
