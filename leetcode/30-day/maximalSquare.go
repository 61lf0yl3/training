package main

import "fmt"

func main() {
	//matrix := [][]byte{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}}
	//matrix := [][]byte{}
	matrix := [][]byte{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 1, 1, 0, 0, 0}}
	fmt.Println(matrix)
	fmt.Println("min test:", Min(2, 0, 1))
	//fmt.Println(maximalSquare(matrix))
}

func maximalSquare(matrix [][]byte) int {
	if matrix == nil || len(matrix) == 0 {
		return 0
	}
	mat := make([][]int, len(matrix)+1)
	max := 0
	for i := 0; i < len(matrix)+1; i++ {
		mat[i] = make([]int, len(matrix[0])+1)
	}
	fmt.Println("mat before:", mat)
	for i := 1; i <= len(matrix); i++ {
		for j := 1; j <= len(matrix[0]); j++ {
			if matrix[i-1][j-1] == byte(1) {
				fmt.Println("i:", i, "	j:", j, "	min:", Min(mat[i-1][j], mat[i][j-1], mat[i-1][j-1]), "	nums:", mat[i-1][j], mat[i][j-1], mat[i-1][j-1])
				mat[i][j] = Min(mat[i-1][j], mat[i][j-1], mat[i-1][j-1]) + 1
				if max < mat[i][j] {
					max = mat[i][j]
				}
			}
		}
	}
	fmt.Println("mat after:", mat)
	return max * max
}

func Min(nb1, nb2, nb3 int) int {
	if nb1 <= nb2 && nb1 <= nb3 {
		return nb1
	}
	if nb2 <= nb1 && nb2 <= nb3 {
		return nb2
	}
	return nb3
}
