package main

import (
	"math"
	"strconv"
)

// func main() {
// 	left := "4"
// 	right := "1000"
// 	fmt.Println(superpalindromesInRange(left, right))
// }

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

func superpalindromesInRange2(left string, right string) int {
	result := 0
	l, r := sqrt(left, math.Ceil), sqrt(right, math.Floor)

	countSuperpalindromes := func(isEven bool) {
		for i := 1; ; i++ {
			p, j := i, i
			if !isEven {
				j /= 10
			}
			for ; j > 0; j /= 10 {
				p *= 10
				p += j % 10
			}
			if p > r {
				break
			}
			if p >= l && isPalindrome(p*p) {
				result++
			}
		}
	}

	countSuperpalindromes(true)
	countSuperpalindromes(false)

	return result
}

// func isPalindrome(x int) bool {
// 	y := 0
// 	for ; x > y; x /= 10 {
// 		y *= 10
// 		y += x % 10
// 	}

// 	return x == y || x == y/10
// }

func sqrt(s string, roundFunc func(float64) float64) int {
	f, _ := strconv.ParseFloat(s, 64)
	return int(roundFunc(math.Sqrt(f)))
}
