package main

import "fmt"

func main() {
	nums := []int{2, 3, 1, 1, 4}
	fmt.Println(jump(nums))
}

func jump(nums []int) int {
	res := 0
	l, r := 0, 0

	for r < len(nums)-1 {
		farthert := 0
		for i := l; i < r+1; i++ {
			farthert = max(farthert, i+nums[i])
		}
		l = r + 1
		r = farthert
		res++
	}
	return res
}

func max(num1, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}
