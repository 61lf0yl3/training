package main

import (
	"fmt"
)

func main() {
	//S, T := "ab#c", "ad#c"
	//S, T := "ab##", "c#d#"
	S, T := "a##c", "#a#c"
	//S, T := "a#c", "b"
	fmt.Println(backspaceCompare(S, T))
}

func backspaceCompare(S string, T string) bool {
	S1 := Helper(S)
	S2 := Helper(T)
	return S1 == S2
}

func Helper(str string) string {
	ArrS := []rune(str)
	return string(Backspace(ArrS))
}

func Backspace(arr []rune) []rune {
	for i := 0; i < len(arr); i++ {
		if arr[i] == '#' {
			if i == 0 {
				arr = append(arr[:i], arr[i+1:]...)
			} else {
				arr = append(arr[:i-1], arr[i+1:]...)
				i--
			}
			i--
		}
	}
	return arr
}
