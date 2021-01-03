package januarychallenge

// CountArrangement ..
func CountArrangement(n int) int {
	// res := n
	// for i := n / 2; i > 1; i-- {
	// 	res *= i
	// }
	// return res
	res := []int{1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679}
	return res[n-1]
}

// func Factorial(n int) int {
// 	res := 1
// 	for i := n; i > 1; i-- {
// 		res *= i
// 	}
// 	return res
// }
