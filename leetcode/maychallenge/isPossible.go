package main

import (
	"fmt"
	"sort"
)

// func main() {
// 	target := []int{9, 3, 5}
// 	fmt.Println(isPossible2(target))
// }

func isPossible(target []int) bool {
	sort.Ints(target)
	fmt.Println(target)
	sum := Sum(target)
	for i := len(target) - 1; i >= 0; i-- {
		if sum-target[i]+1 != target[i] {
			return false
		}
		sum = sum - target[i] + 1
	}
	return true
}

func Sum(arr []int) int {
	sum := 0
	for _, nb := range arr {
		sum += nb
	}
	return sum
}

func isPossible2(target []int) bool {
	sum := 0
	max := 0

	for i := 0; i < len(target); i++ {
		sum += target[i]
		if target[max] < target[i] {
			max = i
		}
	}

	diff := sum - target[max]
	if target[max] == 1 || diff == 1 {
		return true
	}
	if diff > target[max] || diff == 0 || target[max]%diff == 0 {
		return false
	}
	target[max] %= diff
	return isPossible2(target)
}
