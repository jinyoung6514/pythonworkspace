import sys
T = int(sys.stdin.readline())
A,B,C = 0,0,0
while T>=300:
    T-=300
    A+=1
while T>=60:
    T-=60
    B+=1
while T>=10:
    T-=10
    C+=1
if T%10 != 0:
    print(-1)
else:
    print(A,B,C)
