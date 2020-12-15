package novemberchallenge

func flipAndInvertImage(A [][]int) [][]int {
	//make double slice
	res := make([][]int, len(A))
	for i := 0; i < len(A); i++ {
		res[i] = make([]int, len(A[0]))
	}

	for i, v := range A {
		for j := len(v) - 1; j >= 0; j-- {
			//fmt.Println(A[i][j])
			if A[i][j] == 0 {
				res[i][len(v)-1-j] = 1
			} else if A[i][j] == 1 {
				res[i][len(v)-1-j] = 0
			}

		}
	}
	return res
}
