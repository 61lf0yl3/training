package main

import "fmt"

func main() {
	nums := []int{-1}
	//nums := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	//nums := []int{2, -10, 11, 3, 4, -5, 1}
	fmt.Println(maxSubArray(nums))
}
func maxSubArray(nums []int) int {
	var currsum int
	var maxsum = nums[0]

	// for _, nb := range nums {
	// 	currsum += nb
	// 	if currsum <= 0 {
	// 		currsum = 0
	// 	}
	// 	if currsum > maxsum {
	// 		maxsum = currsum
	// 	}
	// }
	for _, nb := range nums {

		currsum += nb
		fmt.Println("nb:", nb)
		fmt.Println("currsum before:", currsum)
		if nb > currsum {
			currsum = nb
		}
		fmt.Println("maxsum before:", maxsum)
		if currsum > maxsum {
			maxsum = currsum
		}
		fmt.Println("currsum after:", currsum)
		fmt.Println("maxsum after:", maxsum)
		fmt.Println()
	}
	return maxsum
}
