package main

import (
	"fmt"
	"strconv"
)

func main() {
	nb := 1300
	counter := 0
	for i := 1; i <= nb; i++ {
		if nb%i == 0 && len(strconv.Itoa(i)) == 2 {
			counter++
		}
	}
	fmt.Println("res:", counter)
}
