package main

// func main() {
// 	boxTypes := [][]int{{5, 10}, {2, 5}, {4, 7}, {3, 9}}
// 	truckSize := 4
// 	fmt.Println(maximumUnits(boxTypes, truckSize))
// }

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

func maximumUnits2(boxTypes [][]int, truckSize int) int {
	counters := [1001]int{0}

	for _, v := range boxTypes {
		counters[v[1]] += v[0]
	}
	result := 0
	for i := 1000; i >= 0; i-- {
		if truckSize == 0 {
			return result
		}
		boxes := min(counters[i], truckSize)
		result += (boxes * i)
		truckSize -= boxes
	}

	return result
}
