# 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
import imp


import sys

N = sys.stdin.readline()
n = set(sys.stdin.readline().split())
M = sys.stdin.readline()
m = list(sys.stdin.readline().split())
for i in m:
    if i in n:
        print("1",end=" ")
    else:
        print("0",end=" ")
