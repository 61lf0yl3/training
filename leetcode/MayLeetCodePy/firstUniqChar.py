class Solution:
    def firstUniqChar(self, s: str) -> int:
        letters = [0]*26
        for char in s:
            letters[ord(char)-97] +=1
        i = 0
        for char in s:
            if letters[ord(char)-97] == 1:
                return i
            i+=1
        return -1

print(Solution.firstUniqChar("loveleetcode"))   
    #print(firstUniqChar( ,'loveleetcode'))

    # def firstUniqChar(self, s: str) -> int:
    #     l = list(s)
    #     count = Counter(l)
    #     for i in count:
    #         if count[i]==1:
    #             return(s.find(i))
    #     else:
    #         return(-1)