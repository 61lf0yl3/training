package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 4}
	nums = []int{1, 1, 1, 1, 1}
	nums = []int{3, 1, 2, 10, 1}
	fmt.Println(runningSum(nums))
}

func runningSum(nums []int) []int {
	res := []int{}
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		//fmt.Println(sum)
		res = append(res, sum)
	}
	return res
}

func runningSum2(nums []int) []int {
	for i := 1; i < len(nums); i++ {
		nums[i] = nums[i-1] + nums[i]
	}

	return nums
}
