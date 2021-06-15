package main

import (
	"fmt"
)

func main() {
	boxTypes := [][]int{{5, 10}, {2, 5}, {4, 7}, {3, 9}}
	truckSize := 4
	fmt.Println(maximumUnits(boxTypes, truckSize))
}

func maximumUnits(boxTypes [][]int, truckSize int) int {
	res := 0
	sortSlice(boxTypes)
	for i := 0; i < len(boxTypes); i++ {
		if boxTypes[i][0] < truckSize {
			truckSize -= boxTypes[i][0]
			res += boxTypes[i][0] * boxTypes[i][1]
		} else if boxTypes[i][0] >= truckSize {
			truckSize = 0
			res = truckSize * boxTypes[i][1]
		}
	}
	return res
}

func sortSlice(boxTypes [][]int) {
	for i := 0; i < len(boxTypes); i++ {
		for j := 0; j < len(boxTypes); j++ {
			if boxTypes[i][1] > boxTypes[j][1] {
				boxTypes[i], boxTypes[j] = boxTypes[j], boxTypes[i]
			}
		}
	}
}
