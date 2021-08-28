import sys
N  = int(sys.stdin.readline())
weight = []
value = []
for _ in range(N):
    w = int(sys.stdin.readline())
    weight.append(w)
weight.sort(reverse=True)
for i in range(1,len(weight)+1):
    value.append(i*weight[i-1])
print(max(value))