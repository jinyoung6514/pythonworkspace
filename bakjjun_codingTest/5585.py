import sys
N = int(sys.stdin.readline())
money = 1000 - N
leftmoney = [500,100,50,10,5,1]
count = 0
for i in leftmoney:
    if money == 0:
        break
    if money >= i:
        while(money>=i):
            money -= i
            count += 1
        continue
print(count)    
