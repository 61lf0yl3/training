package main

import (
	"fmt"
)

func main() {
	arr := []int{2, 2, 1, 1, 1, 2, 2}
	fmt.Println(majorityElement(arr))
}

func majorityElement(nums []int) int {
	m := make(map[int]int)
	for _, l := range nums {
		m[l]++
	}
	fmt.Println("m:", m)
	for _, l := range nums {
		if m[l] > len(nums)/2 {
			return l
		}
	}
	return 0
}
