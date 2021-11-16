import sys
n,m=map(int,sys.stdin.readline().split())
ap = []
bp = []
for i in range(n):
    ap.append(sys.stdin.readline().rstrip())
for i in range(m):
    bp.append(sys.stdin.readline().rstrip())

result = list(set(ap) & set(bp))
print(len(result))
for i in sorted(result):
    print(i)
