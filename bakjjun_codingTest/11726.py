import sys
n = int(sys.stdin.readline())
result = [1,2]
for i in range(2,n+1):
    result.append(result[i-2]+result[i-1])
print(result[n-1]%10007)