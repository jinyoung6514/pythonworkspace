# N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

import sys
N = int(sys.stdin.readline())
result = []
for _ in range(N):
    x = int(sys.stdin.readline())
    result.append(x)
result.sort()
for i in result:
    print(i)