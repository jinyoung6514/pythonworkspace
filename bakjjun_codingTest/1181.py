# 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

# 길이가 짧은 것부터
# 길이가 같으면 사전 순으로
import sys
N = int(sys.stdin.readline())
result = []
lenMin = 50
for _ in range(N):
    word = sys.stdin.readline()
    word_count = len(word)
    result.append((word,word_count))
result = list(set(result))
result.sort(key=lambda word:(word[1],word[0]))
for i in result:
    print(i[0], end='')