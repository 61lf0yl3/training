package main

import "fmt"

// func main() {
// 	grid := [][]int{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
// 	fmt.Println(maxAreaOfIsland(grid))
// }

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
			fmt.Print(grid[y][x])
		}
		fmt.Println()
	}
}

type Island struct {
	grid [][]int
	seen [][]bool
}

func (i *Island) getArea(x int, y int) int {
	if 0 <= x && x < len(i.grid) && 0 <= y && y < len(i.grid[0]) && i.grid[x][y] == 1 && i.seen[x][y] == false {
		i.seen[x][y] = true
		return 1 + i.getArea(x-1, y) + i.getArea(x+1, y) + i.getArea(x, y-1) + i.getArea(x, y+1)
	}
	return 0
}

func maxAreaOfIsland2(grid [][]int) int {
	island := Island{grid: grid, seen: make([][]bool, len(grid))}
	for i := range island.seen {
		island.seen[i] = make([]bool, len(grid[0]))
	}

	max := 0
	for x, row := range island.grid {
		for y := range row {
			area := island.getArea(x, y)
			if area > max {
				max = area
			}
		}
	}
	return max
}
