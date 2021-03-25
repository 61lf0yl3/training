package main

import "fmt"

// func main() {
// 	// s := "abc"
// 	// shift := [][]int{{0, 1}, {1, 2}}
// 	s = "abcdefg"
// 	shift = [][]int{{1, 1}, {1, 1}, {0, 2}, {1, 3}}
// 	fmt.Println(stringShift(s, shift))
// }

func stringShift(s string, shift [][]int) string {
	for _, arr := range shift {
		if arr[0] == 0 { //left shift
			fmt.Println("s before (left shift):", s)
			tmp := s[:arr[1]]
			fmt.Println("tmp (left shift):", tmp)
			s = s[arr[1]:] + tmp
			fmt.Println("s after (left shift):", s)
		}
		if arr[0] == 1 { //right shift
			fmt.Println("s before (right shift):", s)
			tmp := s[len(s)-arr[1]:]
			fmt.Println("tmp (right shift):", tmp)
			s = tmp + s[:len(s)-arr[1]]
			fmt.Println("s after (right shift):", s)
		}
	}
	return s
}
