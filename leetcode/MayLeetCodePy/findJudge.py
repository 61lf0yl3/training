def findJudge( N: int, trust: [[int]]) -> int:
        l = [0] * int(N+1)
        # for arr in trust:
        #     l[arr[0]] -=1
        #     l[arr[1]] +=1
        for i, j in trust:
            print(i)
            print(j)         
            # l[arr[0]] -=1
            # l[arr[1]] +=1
        # for i in range(1,N+1):
        #     if l[i] == N-1:
        #         return i
        return -1

print(findJudge(2, [[1,2]]))