import sys

N,K = map(int, sys.stdin.readline().split())
result = [i for i in range(1,N+1)]

print("<" ,end="")
k = K
for x in range(N):
    if len(result) == 1:
        print("{}>".format(result[0]))
        break
    if k > len(result):
        while k>len(result):
            k -= len(result)
    print("{}, ".format(result[k-1]), end= "")
    result.pop(k-1)
    k+=K-1   
