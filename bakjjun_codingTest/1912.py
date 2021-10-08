import sys
n =  int(sys.stdin.readline())
result = list(map(int,sys.stdin.readline().split()))
cnt = [result[0]]
for i in range(n-1):
    cnt.append(max(cnt[i]+result[i+1],result[i+1]))
print(max(cnt))