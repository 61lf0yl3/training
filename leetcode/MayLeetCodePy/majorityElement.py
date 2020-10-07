def majorityElement(nums: [int]) -> int:
    # res = 0
    # counter = 0
    # for num in nums:
    #     if counter==0:
    #         res, counter = num, 1
    #     else:
    #         if num == res:
    #             counter +=1
    #         else:
    #             counter -=1

    # return res
    nums.sort()
    print(nums)      
    majority = nums[int(len(nums)/2)]
    print(len(nums)//2)
    return majority

            # majority element is the element that appears more
        #than n/2 times
            

input = [1,1,3,3,3,1,1]
print(input)
print(majorityElement(input))