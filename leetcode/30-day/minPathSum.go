package main

// func main() {
// 	grid := [][]int{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}
// 	fmt.Println(minPathSum(grid))
// }

func minPathSum(grid [][]int) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}
	for i, raw := range grid {
		for j := range raw {
			if i > 0 && j > 0 {
				grid[i][j] += Min(grid[i-1][j], grid[i][j-1])
			} else if i > 0 {
				grid[i][j] += grid[i-1][j]
			} else if j > 0 {
				grid[i][j] += grid[i][j-1]
			}
		}
	}
	return grid[len(grid)-1][len(grid[0])-1]
}

func Min(nb1, nb2 int) int {
	if nb1 > nb2 {
		return nb2
	}
	return nb1
}
