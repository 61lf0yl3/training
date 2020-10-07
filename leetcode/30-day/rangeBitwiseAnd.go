package main

import "fmt"

func main() {
	// m := 5
	// n := 7
	m := 4
	n := 8
	fmt.Println(rangeBitwiseAnd(m, n))
}

func rangeBitwiseAnd(m int, n int) int {
	fmt.Println("m:", m)
	fmt.Println("n:", n)
	for m < n {
		n = n & (n - 1)
		fmt.Println("m:", m)
		fmt.Println("n:", n)
	}
	fmt.Println("res:", &n)
	return m & n
}
