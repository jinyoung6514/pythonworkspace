new_id = "z-+.^."

def solution(new_id):
    answer = ''
    sc = ["~","!","@","#","$","%","^","&","*","(",")",'=','+','[','{',']','}',':','?',',','<','>','/']
    new_id = new_id.lower()
    new_id = list(new_id)
    cnt = 0
    for i in range(len(new_id)):
        if new_id[i-cnt] in sc:
            del[new_id[i-cnt]]
            cnt += 1
    cnt = 0
    for i in range(len(new_id)-1):
        if new_id[i+1-cnt] == '.':
            if new_id[i-cnt] == ".":
                del[new_id[i-cnt]]
                cnt += 1

    cnt = len(new_id)
    if cnt != 0:
        if new_id[0] == ".":
            del new_id[0]
            cnt -= 1
    if cnt != 0:
        if new_id[-1] == ".":
            del new_id[-1]
            cnt -= 1
    
    if cnt == 0:
        new_id.append("aaa")
    elif cnt > 15:
        del new_id[15:]
        if new_id[-1] ==".":
            del new_id[-1]
    elif cnt < 3:
        while cnt < 3:
            new_id.append(new_id[cnt-1])
            cnt += 1
            print(cnt)

    answer = ''.join(new_id)
    return answer

print(solution(new_id))