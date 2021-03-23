package main

import "fmt"

// func main() {
// 	nums := []int{2, 5, 5, 2, 8}
// 	fmt.Println(singleNumber(nums))
// }

func singleNumber(nums []int) int {
	// 	nums2 := []int{}
	// 	for _, l1 := range nums {
	// 		counter := 0
	// 		for _, l2 := range nums {
	// 			if l1 == l2 {
	// 				counter++
	// 			}
	// 		}
	// 		nums2 = append(nums2, counter)
	// 	}
	// 	counter := 0
	// 	for _, l2 := range nums2 {
	// 		if l2 == 1 {
	// 			break
	// 		}
	// 		counter++

	// 	}

	// 	return nums[counter]

	for i := 1; i < len(nums); i++ {
		fmt.Println("before nums[0]:", nums[0])
		fmt.Println("nums[i]:", nums[i])
		nums[0] = nums[0] ^ nums[i]
		fmt.Println("after nums[0]:", nums[0])
		fmt.Println()
	}
	return nums[0]
}
