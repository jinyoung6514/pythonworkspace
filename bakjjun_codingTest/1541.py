# 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
# 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
# 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

import sys
formula = sys.stdin.readline().split('-')
result = []
for i in formula:
    cnt = 0
    s = i.split('+')
    for j in s:
        cnt += int(j)
    result.append(cnt)
resultnum = int(result[0]) * 2
for i in result:
    resultnum -= i
print(resultnum)