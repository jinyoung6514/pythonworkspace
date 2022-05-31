
# lottos = [45, 4, 35, 20, 3, 9]
# win_nums = [20, 9, 3, 45, 4, 35]


def solution(lottos, win_nums):
    zero = 0
    num = 7
    result = [0,0]
    for i in lottos:
        if i == 0:
            zero += 1
            continue
        if i in win_nums:
            num -= 1
    if zero == 6:
        result[0] = 1
        result[1] = 6
        return result

    if not num == 7:
        result[1] = num
    else:
        result[1] = 6
    result[0] = result[1] - zero

    return result


# solution(lottos,win_nums)