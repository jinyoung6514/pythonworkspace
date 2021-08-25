# 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
import sys
N = int(sys.stdin.readline())
point = []
for _ in range(N):
    x,y = map(int,sys.stdin.readline().split())
    point.append((x,y))
point.sort(key=lambda x:(x[1],x[0]))
for i in point:
    print(i[0],i[1])