from typing import List


# makesquare
def makesquare(matchticks: List[int]) -> int:
    N = len(matchticks)

    per = sum(matchticks)

    if per % 4 != 0:
        return False
    else:
        side=per//4
    def dfs(a,b,c,d,k):
        if k==N:
            if a==b==c==d:
                return True
            return False
        m = matchticks[k]
        if dfs(a+m,b,c,d,k+1):
            return True
        if dfs(a,b+m,c,d,k+1):
            return True
        if dfs(a,b,c+m,d,k+1):
            return True
        if dfs(a,b,c,d+m,k+1):
            return True



matchticks = [1,1,2,2,2]
print(makesquare(matchticks))