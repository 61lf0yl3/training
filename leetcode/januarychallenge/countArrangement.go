package januarychallenge

// CountArrangement1 ..
func CountArrangement1(N int) int {
	//res := []int{1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679}
	// return res[n-1]

	memo := make([][]int, N)
	for i := range memo {
		memo[i] = make([]int, 1<<N)
		for j := range memo[i] {
			memo[i][j] = -1
		}
	}
	return helper(N, 0, 0, memo)
}

func helper(n, i, chosen int, memo [][]int) int {
	if i == n {
		return 1
	}
	if memo[i][chosen] != -1 {
		return memo[i][chosen]
	}
	ans := 0
	for d := 0; d < n; d++ {
		if chosen&(1<<d) != 0 {
			continue
		}
		if (d+1)%(i+1) == 0 || (i+1)%(d+1) == 0 {
			ans += helper(n, i+1, chosen|(1<<d), memo)
		}
	}
	memo[i][chosen] = ans
	return ans
}

// Factorial ...
func Factorial(n int) int {
	res := 1
	for i := n; i > 1; i-- {
		res *= i
	}
	return res
}
