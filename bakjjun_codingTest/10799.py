A = list(input())

stack = []
result = 0
for i in range(len(A)):
    if A[i] == "(":
        stack.append("(")
    else:
        if A[i-1] == "(":
            stack.pop()
            result +=len(stack)
        else :
            stack.pop()
            result +=1

print(result)