import sys
N = int(sys.stdin.readline())
time = 0
resultTime = 0
result = sorted(list(map(int,sys.stdin.readline().split())))
for i in result:
    time += i
    resultTime += time
print(resultTime)