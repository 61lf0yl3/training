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

func numMatchingSubseq2(s string, words []string) int {
	table := make([]uint16, 26*(len(s)+1))
	prev := [26]uint16{}
	pprev := prev[:]
	for i := 0; i < 26; i++ {
		prev[i] = 0xffff
	}

	copy(table[26*len(s):], pprev)
	for i := uint16(len(s) - 1); i != 0xffff; i-- {
		prev[s[i]-'a'] = i + 1
		copy(table[26*i:], pprev)
	}

	result := 0
Loop:
	for _, word := range words {
		var next uint16
		for i := 0; i < len(word); i++ {
			next = table[next*26+uint16(word[i]-'a')]
			if next == 0xffff {
				continue Loop
			}
		}
		result++
	}
	return result
}
