package novemberchallenge

import (
	"sort"
)

//minCostToMoveChips
func minCostToMoveChips(position []int) int {
	nbeven := 0
	nbodd := 0
	for i := len(position) - 1; i > 1; i-- {
		if position[i] > 2 && position[i]%2 == 0 {
			position[i] = 2
		}
		if position[i] > 2 && position[i]%2 != 0 {
			position[i] = 1
		}
	}
	sort.Ints(position)
	//fmt.Println(position)
	for _, v := range position {
		if v%2 == 0 {
			nbeven++
		} else {
			nbodd++
		}
	}
	if nbeven > nbodd {
		return nbodd
	}
	return nbeven
}
