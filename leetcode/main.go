package main

import (
	"fmt"
	"sort"
)

func main() {
	nums := []int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}
	fmt.Println(longestConsecutive(nums))
}
func longestConsecutive(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	sort.Ints(nums)
	fmt.Println(nums)
	res := 1
	curr := 1
	for i := 1; i < len(nums); i++ {
		fmt.Println("i-1:", nums[i-1]+1, "i:", nums[i])
		if nums[i-1]+1 == nums[i] {
			fmt.Println("pass")
			curr++
			if curr > res {
				res = curr
			}
		} else {
			fmt.Println("out")
			curr = 1
		}
	}
	return res
}
