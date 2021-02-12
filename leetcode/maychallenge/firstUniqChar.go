package main

import "fmt"

// func main() {
// 	s := "leetcode"
// 	//s := "aaa"
// 	fmt.Println(firstUniqChar(s))
// }

func firstUniqChar1(s string) int {
	m := make(map[rune]int, len(s))
	for _, l := range s {
		m[l]++
	}
	for key, value := range s {
		if m[value] == 1 {
			return key
		}
	}
	return -1
}

func firstUniqChar(s string) int {
	chars := make([]int, 26)
	for i := range s {
		chars[int(s[i])-97]++
	}
	fmt.Println("chars:", chars)
	for i := range s {
		if chars[int(s[i])-97] == 1 {
			return i
		}
	}
	return -1
}
