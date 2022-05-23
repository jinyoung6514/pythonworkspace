def solution(id_list, report, k):
    answer = [0]*len(id_list)
    report = set(report)
    check = {}
    dec = {}
    for i in report:
        a,b = i.split(' ')
        if b in check:
            check[b] += 1
        else:
            check[b] = 1
        
        if a in dec:
            if b not in dec[a]:
                dec[a] += [b]
        else:
            dec[a] = [b]
            
    for ckey,cvalue in check.items():
        if cvalue >= k:
            for dkey,dvalue in dec.items():
                if ckey in dvalue:
                    answer[id_list.index(dkey)] += 1
            
    return answer