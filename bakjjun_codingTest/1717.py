import sys
sys.setrecursionlimit(10 ** 6)

n,m = map(int, sys.stdin.readline().split())
parent = [i for i in range(n+1)]

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(x,y):
    x = find(x)
    y = find(y)

    if x== y:
        return
    if x<y:
        parent[y] = x
    else:
        parent[x] = y

for _ in range(m):
    o,a,b = map(int,sys.stdin.readline().split())
    if o==0:
        union(a,b)
    else:
        if find(a) == find(b):
            print("YES")
        else:
            print("NO")
