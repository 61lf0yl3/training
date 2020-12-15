package main

import "fmt"

func main() {
	fmt.Println(isHappy(26))

}

//var counter = 0

func isHappy(n int) bool {
	counter := 0
	for n != 1 {
		res := 0
		for nb := n; nb > 0; nb = nb / 10 {
			res += (nb % 10) * (nb % 10)
		}
		n = res
		counter++
		if counter == 10 {
			return false
		}
	}
	return true
}
