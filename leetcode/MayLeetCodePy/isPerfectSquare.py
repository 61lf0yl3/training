# isPerfectSquare
def isPerfectSquare(num: int) -> bool:
    # for i in range(num+1):
    #      if i > 0:  
    #         if i*i > num:
    #             return False
    #         if num/i == i:
    #             return True
    # return False
    a = num**0.5
    print(a)
    print(int(a))
    if a == int(a):
        return True
    else:
        return False

print(isPerfectSquare(4))