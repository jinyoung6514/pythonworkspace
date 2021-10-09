import sys
n = int(sys.stdin.readline())
grape =[0] * 10000
result = [0] * 10000
for i in range(n):
    grape[i] = int(sys.stdin.readline())
result[0] = grape[0]
result[1] = grape[0]+grape[1]
result[2] = max(grape[0]+grape[2],grape[1]+grape[2],result[1])
for i in range(3,n):
    result[i] = max(result[i-1],grape[i]+result[i-2],result[i-3]+grape[i-1]+grape[i])
print(result[n-1])