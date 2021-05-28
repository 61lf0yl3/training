package main

import "fmt"

func main() {
	cost := []int{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
	fmt.Println(minCostClimbingStairs(cost))
}

func minCostClimbingStairs(cost []int) int {
	for i := 2; i < len(cost); i++ {
		cost[i] += min(cost[i-1], cost[i-2])
	}
	return min(cost[len(cost)-1], cost[len(cost)-2])
}

func min(nb1, nb2 int) int {
	if nb1 > nb2 {
		return nb2
	}
	return nb1
}

func minCostClimbingStairs2(cost []int) int {
	length := len(cost)
	min_cost0, min_cost1 := cost[0], cost[1]
	for i := 2; i < length; i++ {
		min_cost0, min_cost1 = min_cost1, min(min_cost0, min_cost1)+cost[i]
	}
	return min(min_cost0, min_cost1)
}
