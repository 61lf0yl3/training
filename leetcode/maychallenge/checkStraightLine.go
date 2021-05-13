package main

// func main() {
// 	coordinates := [][]int{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}
// 	fmt.Println(checkStraightLine(coordinates))
// }

// checkStraightLine
func checkStraightLine(coordinates [][]int) bool {
	if len(coordinates) == 2 {
		return true
	}
	// (x-x1)/(x2-x1) = (y-y1)(y2-y1)
	x1 := coordinates[0][0]
	y1 := coordinates[0][1]

	x2 := coordinates[1][0]
	y2 := coordinates[1][1]

	xsub := x2 - x1
	ysub := y2 - y1

	for i := 2; i < len(coordinates); i++ {
		x := coordinates[i][0]
		y := coordinates[i][1]
		if x1 != x2 && y != (((x-x1)*ysub)/xsub)+y1 {
			return false
		} else if x1 == x2 && x != x1 {
			return false
		}
	}
	return true
}
