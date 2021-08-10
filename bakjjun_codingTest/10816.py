# 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
# 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
# 이진탐색 알고리즘으로 구현해야함
# upper,lower로 구현하기 후 -를 통해 count추출 
# python으로 작동하면 시간초과 pypy3로 작동하면 됨 
import sys
N = int(sys.stdin.readline())
Num = list(map(int,sys.stdin.readline().split()))
Num.sort()
M = int(sys.stdin.readline())
Mum = list(map(int,sys.stdin.readline().split()))
def Upper_Bound(target, data):
    start = 0
    end = len(data) -1
    while start <= end:
        mid = (start + end) //2
        if data[mid] <= target:
            start = mid+1
        else:
            end = mid-1        
    return end
def Lower_Bound(target, data):
    start = 0
    end = len(data) -1
    while start <= end:
        mid = (start + end) //2
        if data[mid] < target:
            start = mid+1
        else:
            end = mid-1
    return end
for i in range(M):
    count = Upper_Bound(Mum[i],Num) - Lower_Bound(Mum[i],Num)
    print(count,end=" ")



