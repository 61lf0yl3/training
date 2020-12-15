package main

import "fmt"

func main() {
	J := "aA"
	S := "aAAbbbb"
	fmt.Println(numJewelsInStones(J, S))
}

func numJewelsInStones(J string, S string) int {
	m := make(map[rune]int)
	res := 0
	for _, l := range J {
		m[l]++
	}
	fmt.Println("m", m)
	for _, l := range S {
		if _, ok := m[l]; ok {
			res++
		}
	}
	return res
}
