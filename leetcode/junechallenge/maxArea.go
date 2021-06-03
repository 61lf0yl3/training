package main

import (
	"sort"
)

// func main() {
// 	h := 5
// 	w := 4
// 	horizontalCuts := []int{1, 2, 4}
// 	verticalCuts := []int{1, 3}
// 	fmt.Println(maxArea(h, w, horizontalCuts, verticalCuts))
// }

func maxArea(h int, w int, horizontalCuts []int, verticalCuts []int) int {
	maxHorizontalCut := maxDiff(horizontalCuts, h)
	maxVerticalCut := maxDiff(verticalCuts, w)
	return maxHorizontalCut * maxVerticalCut
}

func maxDiff(arr []int, nb int) int {
	arr = append(arr, 0)
	arr = append(arr, nb)
	sort.Ints(arr)
	res := 0
	for i := len(arr) - 1; i > 0; i-- {
		diff := arr[i] - arr[i-1]
		if diff > res {
			res = diff
		}
	}
	return res
}

func maxArea2(h int, w int, hcuts []int, vcuts []int) int {
	sort.Ints(hcuts)
	sort.Ints(vcuts)

	var maxw = hcuts[0] - 0
	for i, c := range hcuts[1:] {
		if c-hcuts[i] > maxw {
			maxw = c - hcuts[i]
		}
	}
	if h-hcuts[len(hcuts)-1] > maxw {
		maxw = h - hcuts[len(hcuts)-1]
	}
	var maxl = vcuts[0] - 0
	for i, c := range vcuts[1:] {
		if c-vcuts[i] > maxl {
			maxl = c - vcuts[i]
		}
	}

	if w-vcuts[len(vcuts)-1] > maxl {
		maxl = w - vcuts[len(vcuts)-1]
	}

	return (maxw * maxl) % (1000000007)
}
