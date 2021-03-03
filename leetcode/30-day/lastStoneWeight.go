package main

import (
	"sort"
)

// func main() {
// 	stones := []int{2, 7, 4, 1, 8, 1, 1}
// 	fmt.Println(lastStoneWeight(stones))
// }
func lastStoneWeight(stones []int) int {
	for len(stones) > 1 {
		sort.Sort(sort.Reverse(sort.IntSlice(stones)))
		if stones[0]-stones[1] > 0 {
			stones = append(stones, stones[0]-stones[1])
		}
		stones = stones[2:]
		if len(stones) == 0 {
			return 0
		}
	}
	return stones[0]
}
