package main

import "fmt"

// func main() {
// 	// text1 := "abcde"
// 	// text2 := "ace"
// 	text1 := "abc"
// 	text2 := "def"
// 	// text1 := "ezupkr"
// 	// text2 := "ubmrapg"
// 	fmt.Println(longestCommonSubsequence(text1, text2))
// }

func longestCommonSubsequence(text1 string, text2 string) int {
	// m := make(map[rune]int)
	// var big string
	// var small string
	// if len(text1) > len(text2) {
	// 	big = text1
	// 	small = text2
	// } else {
	// 	big = text2
	// 	small = text1
	// }
	// bigarr := []rune(big)
	bigarr := []rune(text1)
	// for _, l := range small {
	// 	m[l]++
	// }
	// fmt.Println("m:", m)
	// fmt.Println("bigarr before:", bigarr)
	for i := 0; i < len(bigarr); i++ {
		// fmt.Println("i before:", i)
		// if _, ok := m[bigarr[i]]; !ok && len(bigarr) > 0 {
		//fmt.Println("i before:", i)
		//bigarr = append(bigarr[:i], bigarr[i+1:]...)
		bigarr = append(bigarr[:i], bigarr[i+1:]...)
		i--
		// fmt.Println("i after:", i)
		fmt.Println("bigarr after:", bigarr)
		// fmt.Println()
		// }
		// if _, ok := m[bigarr[i]]; ok {
		// 	DeleteKey(m, bigarr[i])
		// }
	}
	return len(bigarr)
}

// func DeleteKey(m map[rune]int, r rune) {
// 	for key := range m {
// 		if key == r {
// 			delete(m, key)
// 			return
// 		}
// 		delete(m, key)
// 	}
// }
