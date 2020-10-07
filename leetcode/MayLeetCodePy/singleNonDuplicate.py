def singleNonDuplicate(nums: [int]) -> int:
    # print(nums)
    start = 0
    end = len(nums)-1
    # # print(len(nums[0:3+1]))
    # # print(len(nums[3:6]))
    while start <= end:
        mid = (start+end)//2
        # print("start:", start)
        # print("mid:", mid)
        # print("end:", end)
        if (mid < end and nums[mid] != nums[mid-1] and  nums[mid] != nums[mid+1]) or start == end:
            return nums[mid]
        elif nums[mid] == nums[mid-1]: #equal with left part
            # print('len from left',nums[start:mid+1])
            # print('len from right',nums[mid+1:end+1])
            if len(nums[start:mid+1])%2 !=0:
                end = mid
            elif len(nums[mid+1:end+1])%2 !=0:
                start = mid+1
        elif nums[mid] == nums[mid+1]:  #equal with right part
            # print('len from left',nums[start:mid])
            # print('len from right',nums[mid:end+1])
            if len(nums[start:mid])%2 !=0:
                end = mid -1
            elif len(nums[mid:end+1])%2 !=0:
                start = mid
    # print(set(nums))
    # print(set(nums)*2)
    # print(sum((set(nums))*2))
    # print(sum(nums))
    return (sum(set(nums))*2 - sum(nums))

print(singleNonDuplicate([3,3,7,7,10,11,11]))