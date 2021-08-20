
import sys
N = int(sys.stdin.readline())
result = []
for _ in range(N):
    # 문자열로 소팅할경우 사전순으로 정리되므로 1,2,10,20이 아닌 1,10,2,20으로 정렬됨
    point = list(map(int,sys.stdin.readline().split()))
    result.append((point[0],point[1]))
result.sort(key=lambda x:(x[0],x[1]))
for i in result:
    print(i[0],i[1])