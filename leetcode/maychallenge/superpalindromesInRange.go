package main

import (
	"fmt"
	"math"
	"strconv"
)

func main() {
	left := "4"
	right := "1000"
	fmt.Println(superpalindromesInRange(left, right))
}

func superpalindromesInRange(left string, right string) int {
	rightint, _ := strconv.Atoi(right)
	leftint, _ := strconv.Atoi(left)
	var i int = int(math.Round(math.Sqrt(float64(leftint))))
	var res int
	for {
		if i*i > rightint {
			break
		}
		if isPalindrome(strconv.Itoa(i)) && isPalindrome(strconv.Itoa(i*i)) {
			res++
		}
		i++
	}
	return res
}

func isPalindrome(input string) bool {
	for i := 0; i < len(input)/2; i++ {
		if input[i] != input[len(input)-i-1] {
			return false
		}
	}
	return true
}
