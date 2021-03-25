package main

// func main() {
// 	fmt.Println(isPerfectSquare(16))
// }

func isPerfectSquare(num int) bool {
	for i := 1; i <= num; i++ {
		if i*i > num {
			return false
		}
		if float64(num)/float64(i) == float64(i) {
			return true
		}
	}
	return false
}
