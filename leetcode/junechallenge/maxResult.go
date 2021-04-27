package main

import (
	"fmt"
)

func main() {
	nums := []int{1, -5, -20, 4, -1, 3, -6, -3}
	k := 2
	fmt.Println(maxResult(nums, k))
}
func maxResult(nums []int, k int) int {
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
