package main

import "fmt"

func main() {
	A := []int{5, -3, 5}
	fmt.Println("res:", maxSubarraySumCircular(A))
}

func maxSubarraySumCircular(A []int) int {
	const MaxInt = int(^uint(0) >> 1)
	// const MinInt = -MaxInt - 1
	var currsum = -MaxInt - 1
	var maxsum = -MaxInt - 1
	for _, nb := range A {
		currsum = Max(currsum, 0) + nb
		maxsum = Max(currsum, maxsum)
	}
	return maxsum
}

func Max(nb1, nb2 int) int {
	if nb1 > nb2 {
		return nb1
	}
	return nb2
}
