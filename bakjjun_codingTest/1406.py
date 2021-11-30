import sys
left_n = list(sys.stdin.readline().strip())
right_n = []
m = int(sys.stdin.readline())
for i in range(m):
    a = sys.stdin.readline().split()
    if a[0] == "L" :
        if not len(left_n) == 0:
            right_n.append(left_n.pop())
        continue
    elif a[0] == "D" :
        if  not len(right_n) == 0:
            left_n.append(right_n.pop())
        continue
    elif a[0] == "B" :
        if  not len(left_n) == 0:
            left_n.pop()
        continue
    elif a[0] == "P":
        left_n.append(a[1])

right_n.reverse()
left_n.extend(right_n)
for i in left_n:
    print(i,end="")
