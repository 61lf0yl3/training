package main

import "fmt"

type BinaryMatrix struct {
	Get(int, int) int
	Dimensions() []int
}

// func main() {
	
// }

func leftMostColumnWithOne(binaryMatrix BinaryMatrix) int {
		mat := binaryMatrix.Dimensions()
		row := mat[0]
		colunm := mat[1]
		res := 0
		flag := false 
		nb := 0
		startRow := 0
		for i2 := colunm - 1; i2 >=0; i2-- {	
			counter := 0 
			for i1 := startRow; i1 < row; i1++ {
				nb++
				if binaryMatrix.Get(i1, i2) == 1 {
					startRow = i1
					flag = true
					res =i2
					break
				}
				counter++
			   
			}
			if counter == row - startRow {
				break
			}
			}
		fmt.Println("nb:", nb)
		if flag == true {
			return res 
		}
	return -1
}	
	