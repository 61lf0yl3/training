package main

import (
	"fmt"
	"math"
)

// func main() {
// 	fmt.Println(findComplement(5))
// }

func findComplement(num int) int {
	s := fmt.Sprintf("%b", num)
	fmt.Println(s)
	var res float64
	for i, l := range s {
		if l == '0' {
			res += math.Pow(2, float64(len(s)-i-1))
		}

	}
	return int(res)
}
