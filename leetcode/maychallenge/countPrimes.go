package main

import "fmt"

func main() {
	n := 10
	fmt.Println(countPrimes(n))
}
func countPrimes(n int) int {
	res := 0
	for i := 2; i <= n; i++ {
		if isPrime(i) {
			res++
		}
	}
	return res
}

func isPrime(nb int) bool {
	if nb == 0 || nb == 1 {
		return false
	}
	for i := 2; i < nb; i++ {
		if nb%i == 0 {
			return false
		}
	}
	return true
}
