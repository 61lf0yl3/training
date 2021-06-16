package main

import (
	"fmt"
	"sort"
)

func main() {
	matchsticks := []int{1, 1, 2, 2, 2}
	fmt.Println(makesquare(matchsticks))
}
func makesquare(nums []int) bool {
	if len(nums) < 4 {
		return false
	}

	// First do a basic analysis of the number in nums
	ok, avg := analyze(nums)
	if !ok {
		return false
	}

	// Sorting in descending order can speed up dfs
	sort.Sort(sort.Reverse(sort.IntSlice(nums)))

	edges := make([]int, 4)
	return dfs(nums, edges, 0, avg)
}

func dfs(nums, edges []int, index, target int) bool {
	if index == len(nums) {
		if edges[0] == target &&
			edges[1] == target &&
			edges[2] == target {
			return true
		}
		// TODO: Reorganize the program to achieve complete coverage
		return false
	}

	for i := 0; i < 4; i++ {
		if edges[i]+nums[index] > target {
			continue
		}
		edges[i] += nums[index]
		if dfs(nums, edges, index+1, target) {
			return true
		}
		edges[i] -= nums[index]
	}

	return false
}

// analyze Count the sum of the numbers in nums, can it be divisible by 4
func analyze(nums []int) (ok bool, avg int) {
	sum := 0
	for _, n := range nums {
		sum += n
	}
	if sum%4 != 0 {
		return false, 0
	}
	return true, sum / 4
}
