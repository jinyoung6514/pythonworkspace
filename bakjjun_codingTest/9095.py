# 1의 경우 : 1 2의 경우 : 2 3의 경우 : 4
# 4의 경우 : 7 5의 경우 : 13 즉, 구하고자 하는 수의 앞의 숫자 3개를 더하면 다음 숫자의 값이 나온다.
# 11까지의 수를 모두 구해놓고 입력받은 숫자의 경우의 수 출력

import sys
t = int(sys.stdin.readline())
dp = [1,2,4]
for i in range(3,10):
    dp.append(dp[i-3]+dp[i-2]+dp[i-1])
for _ in range(t):
    n = int(sys.stdin.readline())
    print(dp[n-1])
    