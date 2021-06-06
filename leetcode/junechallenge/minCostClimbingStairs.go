package main

import "fmt"

func main() {
	cost := []int{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
	fmt.Println(minCostClimbingStairs(cost))
}

func minCostClimbingStairs(cost []int) int {
	var res int
	for i := 0; i < len(cost)-1; i++ {
		//res += min(cost[i], cost[i+1])
		if cost[i] < cost[i+1] {
			res += cost[i]
		} else {
			res += cost[i+1]
			i++
		}
	}
	return res
}
