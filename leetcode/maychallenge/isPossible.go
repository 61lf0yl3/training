package main

import (
	"fmt"
	"sort"
)

func main() {
	target := []int{9, 3, 5}
	fmt.Println(isPossible(target))
}

func isPossible(target []int) bool {
	sort.Ints(target)
	fmt.Println(target)
	sum := Sum(target)
	for i := len(target) - 1; i >= 0; i-- {
		if sum-target[i]+1 != target[i] {
			return false
		}
		sum = sum - target[i]
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
