package main

import (
	"fmt"
	"sort"
)

// func main() {
// 	//nums := []int{0, 1}
// 	//nums := []int{0, 1, 0}
// 	//nums := []int{0, 1, 1, 0, 1, 1, 1, 0}
// 	nums := []int{0, 0, 0, 1, 1, 1, 0}
// 	//nums := []int{0, 0, 1, 0, 0, 0, 1, 1}
// 	fmt.Println(findMaxLength(nums))

// }

func findMaxLength(nums []int) int {
	m := make(map[int]int)
	m[0] = -1

	sum, res := 0, 0
	fmt.Println("nums:", nums)
	for index := range nums {
		if nums[index] == 0 {
			sum--
		}
		if nums[index] == 1 {
			sum++
		}

		fmt.Println("sum:", sum)
		fmt.Println("m before:", m)

		if value, ok := m[sum]; ok {
			fmt.Println("i:", index)
			fmt.Println("value:", value)
			fmt.Println("res before:", res)
			fmt.Println("index-value", index-value)
			res = max(res, index-value)
			fmt.Println("res after:", res)
		}
		if _, ok := m[sum]; !ok {
			m[sum] = index
		}
		fmt.Println("m after:", m)
		fmt.Println()
	}

	return res
}

// func max(a, b int) int {
// 	if a > b {
// 		return a
// 	}
// 	return b
// }

func findMaxLength2(nums []int) int {
	m := make(map[int]int)
	sum := 0
	res := []int{}
	for i := 0; i < len(nums); i++ {
		fmt.Println("m before:", m)
		if nums[i] == 0 {
			sum += -1
		}
		if nums[i] == 1 {
			sum += 1
		}
		m[sum]++
		fmt.Println("m after:", m)
		fmt.Println()
	}
	for _, val := range m {
		if val*2 <= len(nums) {
			res = append(res, val)
		}
	}
	sort.Ints(res)
	fmt.Println("res after:", res)
	return res[len(res)-1] * 2
}
