package main

import "fmt"

func main() {
	target := 100
	startFuel := 10
	stations := [][]int{{10, 60}, {20, 30}, {30, 30}, {60, 40}}
	fmt.Println(minRefuelStops(target, startFuel, stations))
}

// station[i][0] miles east of the starting position, and has station[i][1] liters of gas.
//my solution
func minRefuelStops(target int, startFuel int, stations [][]int) int {
	if len(stations) > 0 && stations[0][0] > startFuel {
		return -1
	}
	if len(stations) == 0 && target > startFuel {
		return -1
	}
	if len(stations) == 0 && target <= startFuel {
		return 0
	}
	res := 0
	for i := 0; i < len(stations); i++ {
		if stations[i][0] <= startFuel {
			if i < len(stations)-1 && stations[i+1][0] > startFuel {
				res++
				startFuel = startFuel - stations[i][0] + stations[i][1]
			}
			if i == len(stations)-1 {
				res++
				startFuel = startFuel - stations[i][0] + stations[i][1]
			}
		}
	}
	return res
}
