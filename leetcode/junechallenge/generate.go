package main

// func main() {
// 	n := 5
// 	fmt.Println(generate(n))
// }

func generate(numRows int) [][]int {
	rows := [][]int{}
	for i := 1; i <= numRows; i++ {
		a := make([]int, i)
		a[0] = 1
		a[len(a)-1] = 1
		if len(a) > 2 {
			for j := 1; j < i-1; j++ {
				a[j] = rows[i-2][j] + rows[i-2][j-1]
			}
		}
		rows = append(rows, a)
	}
	return rows
}

func generate2(numRows int) [][]int {
	ans := [][]int{}
	for i := 0; i < numRows; i++ {
		ans = append(ans, []int{})
		for j := 0; j < i+1; j++ {
			if j == 0 || j == i {
				ans[i] = append(ans[i], 1)
			} else {
				ans[i] = append(ans[i], ans[i-1][j-1]+ans[i-1][j])
			}
		}
	}
	return ans
}
