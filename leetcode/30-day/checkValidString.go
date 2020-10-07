package main

import "fmt"

func main() {
	s := "(())()"
	//s :=  "(*)"
	//s := "()"
	fmt.Println(checkValidString(s))
}

func checkValidString(s string) bool {
	left := 0
	right := 0
	for i, l := range s {
		if l == ')' {
			left--
		} else {
			left++
		}
		if s[len(s)-1-i] == '(' {
			right--
		} else if s[len(s)-1-i] == ')' || s[len(s)-1-i] == '*' {
			right++
		}
		if right < 0 || left < 0 {
			return false
		}
	}
	return true
}
