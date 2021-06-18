package main

import (
	"fmt"
)

func main() {
	a := []string{"A", "B", "C", "D", "E"}
	a = nil
	fmt.Println(a, len(a), cap(a))
	a = append(a, "A")
	fmt.Println(a, len(a), cap(a))
}

func numSubarrayBoundedMax2(nums []int, left int, right int) int {
	return getAnswerPerBound(nums, right) - getAnswerPerBound(nums, left-1)
}

func getAnswerPerBound(nums []int, bound int) int {
	res, count := 0, 0
	for _, num := range nums {
		if num <= bound {
			count++
		} else {
			count = 0
		}
		res += count
	}
	return res
}
