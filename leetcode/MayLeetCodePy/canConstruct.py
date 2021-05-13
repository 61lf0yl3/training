
# Solutions
class Solution:
    res = canConstruct('aa', 'aab')
    print(res)
    
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        mag = list(magazine)
        for ran in ransomNote:
            if ran in mag:
                # print(mag)
                mag.remove(ran)
            else:
                return False

        return True



class Solution2:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        for item in ransomNote:
            if not item in magazine:
                return False
            magazine = magazine.replace(item, "", 1)
        return True

