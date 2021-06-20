package main

import "fmt"

// func main() {
// 	//s := "abcde"
// 	words := []string{"a", "bb", "acd", "ace"}
// 	//fmt.Println(numMatchingSubseq(s, words))
// 	words[0] = words[0][1:]
// 	fmt.Println(words)
// 	words[0] = words[0][1:]
// 	fmt.Println(len(words[0]))
// }

func numMatchingSubseq(s string, words []string) int {
	res := 0
	for i := 0; i < len(s); i++ {
		//fmt.Println(string(s[i]))
		for j := 0; j < len(words); j++ {
			//fmt.Println(string(s[i]),"compare", words[j])
			if len(words[j]) == 0 {
				continue
			}
			if s[i] == words[j][0] {
				//fmt.Println(string(s[i]), "==", words[j])
				words[j] = words[j][1:]

				if len(words[j]) == 0 {
					res++
				}
			}
		}
	}
	fmt.Println(words)
	return res
}
