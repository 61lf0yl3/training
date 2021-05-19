package main

import (
	"fmt"
	"math"
)

func main() {
	n := 2
	fmt.Println(countPrimes(n))
}
func countPrimes(n int) int {
	res := 0
	for i := 0; i <= n; i++ {
		if i == 2 || i == 3 || i == 5 {
			res++
			continue
		}
		if isPrime(i) {
			res++
		}
	}
	return res
}
func isPrime(nb int) bool {
	for i := 2; i <= int(math.Floor(math.Sqrt(float64(nb)))); i++ {
		if nb%i == 0 {
			return false
		}
	}
	return nb > 1
}

// slow isPrime
// func isPrime(nb int) bool {
// 	if nb == 0 || nb == 1 {
// 		return false
// 	}
// 	for i := 2; i < nb; i++ {
// 		if nb%i == 0 {
// 			return false
// 		}
// 	}
// 	return true
// }

func countPrimes2(n int) int {
	if n <= 2 {
		return 0
	}
	nums := make([]bool, n)
	primes := 1

	for i := 0; i < n; i++ {
		nums[i] = true
	}

	for i := 3; i < n; i += 2 {
		if nums[i] {
			primes++
			for j := i * i; j < n; j += 2 * i {
				nums[j] = false
			}
		}
	}

	return primes
}
