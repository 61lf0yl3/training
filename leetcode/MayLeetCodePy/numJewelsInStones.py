class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        res = 0
        for jewel in J:
            for stone in S:
                if jewel==stone:
                    res +=1
        
        return res 

        # jewels = set(J)
        # count = 0
        # for stone in S:
        #     if stone in jewels:
        #         count += 1
                
        # return count

        # count = 0
        # for letter in S:
        #     if letter in J:
        #         count += 1
        # return count