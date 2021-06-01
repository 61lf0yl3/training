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
			if grid[y][x] == 1 {
				res++
				BFS(grid, y, x, res)
			}
		}
	}
	return res
}

func BFS(grid [][]int, y, x, res int) {
	PrintGrid(grid)
	fmt.Println(res)
	fmt.Println()
	if y < 0 || y >= len(grid) || x < 0 || x >= len(grid[y]) || grid[y][x] == 0 {
		return
	}
	grid[y][x] = 0
	BFS(grid, y+1, x, res) // check up
	BFS(grid, y-1, x, res) // check down
	BFS(grid, y, x+1, res) // check right
	BFS(grid, y, x-1, res) // check left
}

func PrintGrid(grid [][]int) {
	for y := range grid {
		for x := range grid[y] {
			fmt.Print(grid[y][x])
		}
		fmt.Println()
	}
}
