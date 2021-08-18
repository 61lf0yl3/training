package main

import (
	"fmt"
	"sort"
)

func merge(intervals [][]int) [][]int {
	var res [][]int
	res = append(res, intervals[0])
	fmt.Println(len(intervals))
	for i := 0; i < len(intervals); i++ {
		for j := 0; j < len(res); i++ {
			if overlap(intervals[i], res[j]) {
				min, max := minAndMax(intervals[i], res[j])
				res[j][0] = min
				res[j][1] = max
			} else {
				if intervals[i][0] < res[j][0] {
					res = append([][]int{intervals[i]}, res...)
				} else {
					res = append(res, intervals[i])
				}
			}
		}
	}
	return res
}

func overlap(arr1, arr2 []int) bool {
	if arr2[0] < arr1[0] {
		arr1, arr2 = arr2, arr1
	}
	if arr2[0] < arr1[1] {
		return true
	}
	return false
}

func minAndMax(arr1, arr2 []int) (int, int) {
	var arr []int
	arr = append(arr1, arr2...)
	sort.Ints(arr)
	fmt.Println(arr)
	return arr[0], arr[len(arr)-1]
}
