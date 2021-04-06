package novemberchallenge

import "fmt"

//longestMountain ...
func longestMountain(arr []int) int {
	var res int
	var peakindex int
	for i := 1; i < len(arr)-1; i++ {
		if arr[i] > arr[i-1] && arr[i] > arr[i+1] {
			peakindex = i
		}
	}
	fmt.Println(peakindex)
	if peakindex == 0 {
		return 0
	}
	for i := 0; i < len(arr)-1; i++ {
		if i < peakindex {
			if arr[i] < arr[i+1] {
				res++
				//fmt.Println(arr[i])
			}
		}
		if i >= peakindex {
			//fmt.Println(arr[i])
			if arr[i] > arr[i+1] {
				res++
				// fmt.Println(arr[i])
			}

		}
	}
	if res > 0 {
		res++
	}
	return res
}
