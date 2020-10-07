package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	if len(os.Args[1:]) != 1 {
		fmt.Println("too many argumnets")
		return
	}
	input := os.Args[1]
	nb, err := strconv.Atoi(input)
	if err != nil {
		panic(err)
	}
	nbarr := []int{}
	for i := 1; i <= nb; i++ {
		nbarr = append(nbarr, i)
	}

	for len(nbarr) > 0 {
		fmt.Println(nbarr)
		counter := 0
		for i := 0; i < len(nbarr); i++ {
			counter++
			if counter == 3 {
				counter = 0
				continue
			}
			nbarr = append(nbarr[:i], nbarr[i+1:]...)
			i--
			// if i+1%2 != 0 {
			// 	nbarr = append(nbarr[:i], nbarr[i+1:]...)  for each 2
			// }
			if len(nbarr) == 2 {
				fmt.Println(nbarr[0], "and", nbarr[1])
				return
			}
			if len(nbarr) == 1 {
				fmt.Println(nbarr[0])
				return
			}
		}
	}
}
