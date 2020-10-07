
def findComplement(num: int) -> int:
    binary = bin(num)[2:]
    print(binary)
    res = 0
    i = 0
    length = len(binary)-1
    # for nb in binary:
    while length >= 0:
        if binary[length] == '0':
            res += 2 ** i
        i+=1
        length -=1
    #print(res)
    return res


print(findComplement(2))


# class Solution:
#     def findComplement(self, num: int) -> int:
#         temp = bin(num)[2:]
#         result = ""
#         for s in temp:
#             result += str(1-int(s))
#         return int(result,2)

# class Solution:
#     def findComplement(self, num: int) -> int:
#         b_str = bin(num).replace('0b', '')
#         mask_str = ''.join(['1'] * len(b_str))
#         return num ^ int(mask_str, 2)