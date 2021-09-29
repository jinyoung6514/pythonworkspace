import sys
result = [0,1]
n = int(sys.stdin.readline())
for i in range(2,n+1):
    result.append(result[i-2]+result[i-1])
print(result[n])