#  'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.

# 게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 
# 뱀은 처음에 오른쪽을 향한다.

# 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

# 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
# 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
# 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
# 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.

import sys
from collections import deque
def change(d,c):
    if c=="L":
        d = (d-1) % 4
    else:
        d = (d+1) % 4
    return d

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
def start():
    direction = 1
    time = 1
    y,x = 0,0
    visited = deque([[y,x]])
    board[y][x] = 2
    while True:
        y,x = y+dy[direction], x+dx[direction]
        if 0<=y<N and 0<=x<N and board[y][x] !=2:
            if not board[y][x] == 1:
                temp_y,temp_x = visited.popleft()
                board[temp_y][temp_x] = 0
            board[y][x] = 2
            visited.append([y,x])
            if time in times.keys():
                direction = change(direction, times[time])
            time += 1
        else:  # 본인 몸에 부딪히거나, 벽에 부딪힌 경우
            return time

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    K = int(sys.stdin.readline())
    board = [[0] * N for _ in range(N)]
    # 사과 위치를 1로 설정
    for _ in range(K):
        a,b = map(int, sys.stdin.readline().split())
        board[a-1][b-1] = 1
    L = int(sys.stdin.readline())
    times = {}
    for  _ in range(L):
        x,c = sys.stdin.readline().split()
        times[int(x)] = c
    print(start())