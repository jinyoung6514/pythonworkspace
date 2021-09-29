import sys
t = int(sys.stdin.readline())
result = [[1,0],[0,1]]
for i in range(2,41):
    result.append([result[i-2][0] + result[i-1][0],result[i-2][1]+result[i-1][1]])

for _ in range(t):
    n = int(sys.stdin.readline())
    print(result[n][0],result[n][1])