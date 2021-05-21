package main

// func main() {
// 	cardPoints := []int{1, 2, 3, 4, 5, 6, 1}
// 	k := 3
// 	fmt.Println(maxScore(cardPoints, k))
// }

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

func maxScore2(cardPoints []int, k int) int {
	//sliding window approach
	//essentially, find the sum of first K elements,
	//and then start adding the last k elements by removing one elem from the right of the first k elements
	//if the sum is higher than previously found max, update it
	//return the max

	maxSum := 0
	//find first k sum
	for i := 0; i < k; i++ {
		maxSum += cardPoints[i]
	}

	//start from the back and end of the start from the start
	gMaxSum := maxSum
	for i := 0; i < k; i++ {
		maxSum += cardPoints[len(cardPoints)-1-i] - cardPoints[k-1-i]
		//fmt.Printf("MaxSum: %d\n", maxSum)
		if maxSum > gMaxSum {
			gMaxSum = maxSum
		}
	}

	return gMaxSum
}
