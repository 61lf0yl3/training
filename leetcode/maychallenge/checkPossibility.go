package main

import (
	"fmt"
)

// func main() {
// 	nums := []int{4, 2, 1}
// 	//nums = []int{1, 3, 2}
// 	//nums = []int{3, 4, 2, 3}
// 	//nums = []int{5, 7, 1, 8}
// 	fmt.Println(checkPossibility(nums))
// }

func checkPossibility(nums []int) bool {
	error1 := 0
	for i := 1; i < len(nums); i++ {
		if nums[i-1] > nums[i] {
			if i < len(nums)-1 && nums[i-1] > nums[i+1] {
				nums[i-1] = nums[i]
			} else {
				nums[i] = nums[i-1]
			}
			break
		}
	}
	for i := 1; i < len(nums); i++ {
		if nums[i-1] > nums[i] {
			//fmt.Print(i)
			error1++
		}
	}
	fmt.Println(nums)
	//fmt.Println(error1)
	return error1 == 0
}

func checkPossibility2(nums []int) bool {
	c, p := 0, 0
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] > nums[i+1] {
			c += 1
			p = i + 1
		}
	}
	if c == 0 {
		return true
	} else if c > 1 {
		return false
	} else {
		if p == 1 || p == len(nums)-1 {
			return true
		} else {
			return ((nums[p-1] <= nums[p+1]) || (nums[p-2] <= nums[p]))
		}
	}
}

// func Recursive(nums, i1, i2 int) bool {
// 	if nums[i1] > nums[i2] {
// 		Recursive(nums, i1-1, )
// 	}
// 	return false
// }
