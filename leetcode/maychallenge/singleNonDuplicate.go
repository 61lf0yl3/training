package main

import "fmt"

func main() {
	nums := []int{1, 1, 2, 3, 3, 4, 4, 8, 8}
	fmt.Println(singleNonDuplicate(nums))
}

// func singleNonDuplicate(nums []int) int {
// 	fmt.Println(nums[len(nums)-1])
// 	list := make([]int, nums[len(nums)-1]+1)
// 	for _, l := range nums {
// 		list[l]++
// 	}
// 	for i, l := range list {
// 		if l == 1 {
// 			return i
// 		}
// 	}
// 	// fmt.Println(list)
// 	return 0
// }

func singleNonDuplicate(nums []int) int {
	fmt.Println(nums)
	s, e := 0, len(nums)-1
	for s < e {
		m := s + (e-s)/2
		// doesn't match left or right element, this is the single element
		if (m > 0 && nums[m] != nums[m-1]) && (m < len(nums)-1 && nums[m] != nums[m+1]) {
			return nums[m]
		} else {
			// even index
			if m%2 == 0 {
				// matches left
				if m > 0 && nums[m] == nums[m-1] {
					e = m - 2
					// matches right
				} else {
					s = m + 2
				}
				// odd index
			} else {
				// matches left
				if m > 0 && nums[m] == nums[m-1] {
					s = m + 1
					// matches right
				} else {
					e = m - 1
				}
			}
		}
	}
	return nums[s]
}
