# 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
# 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
# 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
# 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
# 그리디 알고리즘을 이용
import sys
N = int(sys.stdin.readline())
result = []
count = 1
for _ in range(N):
    time = list(map(int,sys.stdin.readline().split()))
    result.append((time[0],time[1]))
result.sort(key=lambda x:(x[1],x[0]))
end_time = result[0][1]
for i in range(1,N):
    if result[i][0] >= end_time:
        count += 1
        end_time = result[i][1]
print(count)