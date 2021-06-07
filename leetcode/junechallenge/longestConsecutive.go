package main

import (
	"fmt"
	"sort"
)

// func main() {

// }

func longestConsecutive(nums []int) int {
	if len(nums) == 0 {
		return 0
	} else if len(nums) == 1 {
		return 1
	}
	sort.Ints(nums)
	fmt.Println(nums)
	res := 1
	curr := 1
	for i := 1; i < len(nums); i++ {
		fmt.Println("i-1:", nums[i-1]+1, "i:", nums[i])
		if nums[i-1]+1 == nums[i] {
			curr++
			if curr > res {
				res = curr
			}
		} else if nums[i-1] == nums[i] {
			continue
		} else {
			curr = 1
		}

	}
	return res
}

func longestConsecutive2(nums []int) int {
	sort.Ints(nums)
	if len(nums) == 0 {
		return 0
	}
	res := 1
	seq := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[i-1]+1 {
			seq++
			continue
		}
		if nums[i] == nums[i-1] {
			continue
		}
		res = max(res, seq)
		seq = 1
	}
	res = max(res, seq)
	return res
}

func max(x int, y int) int {
	if x > y {
		return x
	}
	return y
}
