package main

// func main() {
// 	//grid := [][]byte{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}}
// 	grid := [][]byte{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}}
// 	fmt.Println(numIslands(grid))
// }

func numIslands(grid [][]byte) int {
	res := 0
	for y := range grid {
		for x := range grid[y] {
			if grid[y][x] == 1 {
				res++
				BFS(grid, y, x)
			}
		}
	}
	return res
}

func BFS(grid [][]byte, y, x int) {
	if y < 0 || y >= len(grid) || x < 0 || x >= len(grid[y]) || grid[y][x] == 0 {
		return
	}
	grid[y][x] = 0
	BFS(grid, y+1, x) // check up
	BFS(grid, y-1, x) // check down
	BFS(grid, y, x+1) // check right
	BFS(grid, y, x-1) // check left
}
