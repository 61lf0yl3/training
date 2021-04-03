package main

import "fmt"

func main() {
	res := 1

	for i := 2; i <= 10; i++ {
		res = res*10 + i
	}
	fmt.Println(res)

}
