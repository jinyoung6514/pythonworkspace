import sys

input = int(sys.stdin.readline())

for a in range(input):
    i = sys.stdin.readline()
    count = 0
    
    strlegnth = len(i)

    for b in range(strlegnth):
        if count<0:
            print("NO")
            break
        elif i[b] == '(':
            count+=1
        elif i[b] == ')':
            count-=1
    
    if count >0:
        print("NO")
    elif count ==0 :
        print("YES")
    
    
    