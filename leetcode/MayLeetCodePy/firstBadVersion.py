class Solution:  
# firstBadVersion
  def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        start = 1
        end = n
        while start < end:
            if isBadVersion(start):
                return start
            mid = (start+end)//2
            if isBadVersion(mid):
                end = mid 
            elif not isBadVersion(mid):
                start = mid + 1
            else:
                start+=1
	    
        return end