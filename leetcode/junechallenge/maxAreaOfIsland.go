package main

import "fmt"

func main() {
	grid := [][]int{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
	fmt.Println(maxAreaOfIsland(grid))
}

func maxAreaOfIsland(grid [][]int) int {
	res := 0
	for y := range grid {
		for x := range grid[y] {
			curr := 0
			if grid[y][x] == 1 {
				//res++
				BFS(grid, y, x, &curr)
			}
			if curr > res {
				res = curr
			}
		}
	}
	return res
}

func BFS(grid [][]int, y, x int, curr *int) {
	PrintGrid(grid)
	fmt.Println(*curr)
	fmt.Println()
	if y < 0 || y >= len(grid) || x < 0 || x >= len(grid[y]) || grid[y][x] == 0 {
		return
	}
	if grid[y][x] == 1 {
		*curr++
	}
	grid[y][x] = 0
	BFS(grid, y+1, x, curr) // check up
	BFS(grid, y-1, x, curr) // check down
	BFS(grid, y, x+1, curr) // check right
	BFS(grid, y, x-1, curr) // check left
}

func PrintGrid(grid [][]int) {
	for y := range grid {
		for x := range grid[y] {
			a
			fmt.Print(grid[y][x])
		}
		fmt.Println()
	}
}
