package main

import (
	"fmt"

	"./decemberchallenge"
)

func main() {
	flowerbed := []int{1, 0, 0, 0, 0, 1}
	flowerbed = []int{0, 0, 1, 0, 1}
	flowerbed = []int{0}
	n := 1
	fmt.Println(decemberchallenge.CanPlaceFlowers(flowerbed, n))
}
