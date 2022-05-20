# N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
import sys

N = int(sys.stdin.readline())
A = set(sys.stdin.readline().split())
M = int(sys.stdin.readline())
B = sys.stdin.readline().split()
for i in B:
    if i in A:
        print("1")
    else:
        print("0")