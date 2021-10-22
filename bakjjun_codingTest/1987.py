# import sys
# r,c = map(int,sys.stdin.readline().split())
# board = [list(sys.stdin.readline().strip()) for _ in range(r)]
# dx = [-1,0,1,0]
# dy = [0,1,0,-1]
# q = []
# result = 1

# def dfs(a,b,res):
#     global result
#     result = max(res,result)
#     for i in range(4):
#         x = a + dx[i]
#         y = b + dy[i]
#         if 0<=x<r and 0<=y<c and (board[x][y] not in q):
#             q.append(board[x][y])
#             dfs(x,y,res+1)
#             q.remove(board[x][y])
# q.append(board[0][0])
# dfs(0,0,result)
# print(result)

import sys

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def BFS(x, y):
    global answer
    q = set([(x, y, board[x][y])])

    while q:
        x, y, ans = q.pop()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if ((0 <= nx < R) and (0 <= ny < C)) and (board[nx][ny] not in ans):
                q.add((nx,ny,ans + board[nx][ny]))
                answer = max(answer, len(ans)+1)


R, C = map(int, sys.stdin.readline().split())
board = [list(sys.stdin.readline().strip()) for _ in range(R)]

answer = 1
BFS(0, 0)
print(answer)