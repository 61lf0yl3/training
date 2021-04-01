package main

import "fmt"

func main() {
	candyType := []int{1, 1, 2, 2, 3, 3}
	fmt.Println(distributeCandies(candyType))
}

func distributeCandies(candyType []int) int {
	recomendedNb := len(candyType) / 2
	m := make(map[int]int)
	for _, v := range candyType {
		m[v]++
	}
	// fmt.Println(recomendedNb)
	// fmt.Println(len(m))
	return IsMin(recomendedNb, len(m))
}

func IsMin(nb1, nb2 int) int {
	if nb1 < nb2 {
		return nb1
	}
	return nb2
}
