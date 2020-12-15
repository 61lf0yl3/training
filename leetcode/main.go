package main

import (
	"fmt"

	"github.com/61lf0yl3/training/leetcode/decemberchallenge"
)

func main() {
	// flowerbed := []int{1, 0, 0, 0, 0, 1}
	// flowerbed = []int{0, 0, 1, 0, 1}
	// flowerbed = []int{0}
	// n := 1
	// fmt.Println(decemberchallenge.CanPlaceFlowers(flowerbed, n))

	time := []int{30, 20, 150, 100, 40}
	fmt.Println(decemberchallenge.NumPairsDivisibleBy60(time))
}
