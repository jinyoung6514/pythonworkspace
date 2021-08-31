import sys
s = int(sys.stdin.readline())
n = 1
while(True):
    if s < n*(n+1)/2:
        break
    n += 1
print(n-1)
