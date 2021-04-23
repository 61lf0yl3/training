package main

import "fmt"

// func main() {
// 	// N := 4
// 	// trust := [][]int{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}
// 	// N := 3
// 	// trust := [][]int{{1, 2}, {2, 3}}
// 	N := 2
// 	trust := [][]int{{1, 2}}
// 	fmt.Println("res:", findJudge(N, trust))
// }

// findJudge
func findJudge(N int, trust [][]int) int {
	a := make([]int, N+1)

	for _, p := range trust {
		fmt.Println(p[0])
		a[p[0]]--
		a[p[1]]++
	}
	for i := 1; i < N+1; i++ {
		if a[i] == N-1 {
			return i
		}
	}
	return -1
}
