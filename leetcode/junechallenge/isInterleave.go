package main

import "fmt"

func main() {
	// s1 := "aabcc"
	// s2 := "dbbca"
	// s3 := "aadbbcbcac"
	s1 := "abx"
	s2 := "mbn"
	s3 := "ambbnx"
	fmt.Println(isInterleave(s1, s2, s3))
}

func isInterleave(s1 string, s2 string, s3 string) bool {
	matrix := make([][]bool, len(s1)+1)
	for i := 0; i <= len(s1); i++ {
		matrix[i] = make([]bool, len(s2)+1)
	}
	matrix[0][0] = true
	for i := 0; i <= len(s1); i++ {
		for j := 0; j <= len(s2); j++ {
			Print(matrix)
			fmt.Println("i:", i, "j:", j)
			fmt.Println()
			if len(s1) != 0 && i < len(s1) && s1[i] == s3[j+i] && matrix[i][j] == true {
				matrix[i+1][j] = true
			}
			if len(s2) != 0 && j < len(s2) && s2[j] == s3[j+i] && matrix[i][j] == true {
				matrix[i][j+1] = true
			}
		}
	}
	Print(matrix)
	return matrix[len(s1)][len(s2)]
}

func Print(matrix [][]bool) {
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix); j++ {
			fmt.Print(matrix[i][j])
			fmt.Print(" ")
		}
		fmt.Println()
	}
}

func isInterleave2(s1 string, s2 string, s3 string) bool {
	for _, v := range s3 {
		if len(s1) > 0 && byte(v) == s1[0] {
			s1 = s1[1:]
			fmt.Println(s1)
			continue
		}
		if len(s2) > 0 && byte(v) == s2[0] {
			s2 = s2[1:]
			fmt.Println(s2)
			continue
		} else {
			return false
		}
	}
	return true
}
