package main

import "fmt"

func main() {
	cardPoints := []int{1, 2, 3, 4, 5, 6, 1}
	k := 3
	fmt.Println(maxScore(cardPoints, k))
}

func maxScore(cardPoints []int, k int) int {
	left_sum := []int{0}
	right_sum := []int{0}
	for i := 0; i < k; i++ {
		left_sum = append(left_sum, left_sum[i]+cardPoints[i])
		right_sum = append(right_sum, right_sum[i]+cardPoints[len(cardPoints)-i-1])
	}
	//fmt.Println(left_sum, right_sum)
	res := 0
	for i := 0; i < len(left_sum); i++ {
		max := left_sum[i] + right_sum[len(right_sum)-1-i]
		if max > res {
			res = max
		}
	}
	return res
}
