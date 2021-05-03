package main

import (
	"fmt"
)

// func main() {
// 	nums := []int{1, -5, -20, 4, -1, 3, -6, -3}
// 	k := 2
// 	fmt.Println(maxResult(nums, k))
// }
func maxResult(nums []int, k int) int {
	Min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}
	Max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}
	sums := make([]int, len(nums))
	sums[len(nums)-1] = nums[len(nums)-1]
	for i := len(nums) - 2; i > -1; i-- {
		sums[i] = nums[i]
		max := sums[i+1]
		for j := i + 1; j <= Min(len(nums)-1, i+k); j++ {
			max = Max(max, sums[j])
			if nums[j] > 0 {
				break
			}
		}
		sums[i] += max
	}
	return sums[0]
}

//
func maxResult2(nums []int, k int) int {
	var res = nums[0]
	fmt.Println("nums:", nums)
	fmt.Println()

	for i := 1; i < len(nums); i++ {
		fmt.Println("before i:", i)
		fmt.Println("value i:", nums[i])
		//fmt.Println("nums:", nums)

		max := nums[i]
		maxindex := i
		fmt.Println("newnums:", nums[i:min(len(nums), i+k)])
		for j := i; j < min(len(nums), i+k); j++ {
			if nums[j] > max {
				max = nums[j]
				maxindex = j
			}
		}
		res += max
		i = maxindex
		fmt.Println("max:", max)
		fmt.Println("after i:", i)
		fmt.Println()
	}
	return res
}

func min(nb1, nb2 int) int {
	if nb1 > nb2 {
		return nb2
	}
	return nb1
}
