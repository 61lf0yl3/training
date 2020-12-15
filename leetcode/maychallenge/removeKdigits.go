package main

import (
	"fmt"
)

func main() {
	// num := "1432219"
	// k := 3
	num := "10200"
	k := 1
	// num := "10"
	// k := 1
	fmt.Println(removeKdigits(num, k))
}

func removeKdigits(num string, k int) string {
	var res string
	var r rune = '0'
	nbword := len(num) - k
	for k >= 0 {
		for i := 0; i < len(num); i++ {
			fmt.Println("nb:", string(num[i]))
			fmt.Println("r", string(r))
			if rune(num[i]) == r && len(num[i:]) >= nbword {
				nbword--
				k--
				//	if num[i] > '0' && k > 1 {
				res += string(num[i])
				//	}
				num = num[i+1:]
				r = '0'
				fmt.Println("num:", num)
			}
		}
		r++
	}
	// fmt.Println("\n", "res:", res)
	return res
}
