package main

import (
	"sort"
)

// func main() {
// 	matchsticks := []int{1, 1, 2, 2, 2}
// 	fmt.Println(makesquare(matchsticks))
// }
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

func makesquare2(arr []int) bool {
	if len(arr) < 4 {
		return false
	}
	total := 0
	for _, v := range arr {
		total += v
	}
	if total%4 != 0 {
		return false
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i] > arr[j]
	})
	visited := make([]bool, 16)

	var dfs func([]int, int, int, int) bool
	dfs = func(arr []int, cur int, grp int, sum int) bool {
		if grp == 4 {
			return true
		}
		if sum > total/4 {
			return false
		}
		if sum == total/4 {
			return dfs(arr, 0, grp+1, 0)
		}

		last := -1
		for i := cur; i < len(arr); i++ {
			if visited[i] {
				continue
			}
			if last == arr[i] {
				continue
			}

			visited[i] = true
			last = arr[i]
			if dfs(arr, i+1, grp, sum+arr[i]) {
				return true
			}
			visited[i] = false
		}
		return false
	}
	return dfs(arr, 0, 0, 0)
}
