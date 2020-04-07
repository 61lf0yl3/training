package main

import "fmt"

func main() {
	//nums := []int{0, 1, 0, 3, 12}
	nums := []int{4, 2, 4, 0, 0, 3, 0, 5, 1, 0}
	moveZeroes(nums)
	fmt.Println(nums)
}

func moveZeroes(nums []int) {
	// for i1, i2 := 0, 0; i1 < len(nums); i1++ {
	// 	if nums[i1] == 0 {
	// 		nums[i1], nums[i2] = nums[i2], nums[i1]
	// 		i2++
	// 	}
	// }
	for i1 := range nums {
		for i2 := range nums {
			if nums[i1] != 0 && nums[i2] == 0 {
				nums[i2], nums[i1] = nums[i1], nums[i2]
			}
		}
	}
}
