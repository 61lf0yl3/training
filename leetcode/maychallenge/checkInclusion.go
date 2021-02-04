package main

import (
	"fmt"
	"reflect"
)

func main() {
	var s1, s2 string
	// s1 = "ab"
	// s2 = "eidbaooo"
	s1 = "adc"
	s2 = "dcda"
	fmt.Println("res:", checkInclusion(s1, s2))
}

func checkInclusion(s1 string, s2 string) bool {
	// slice1 := strings.Split(s1, "")
	// sort.Strings(slice1)
	// s1 = strings.Join(slice1, "")
	// fmt.Println(slice1)
	m1 := make(map[rune]int, len(s1))
	for _, l := range s1 {
		m1[l]++
	}
	fmt.Println("m1:", m1, "\n")
	m2 := make(map[rune]int, len(s1))
	for _, l := range s2 {
		fmt.Println("m2 before1:", m1)
		m2[l]++
		// if i >= len(s1) {
		// 	m2[rune(s2[i-len(s1)])]--
		// }
		// m2[l]++
		fmt.Println("m2 after:", m1)
		if reflect.DeepEqual(m1, m2) == true {
			return true
		}
		// if i+len(s1) <= len(s2) {
		// 	temp := strings.Split(s2[i:i+len(s1)], "")
		// 	sort.Strings(temp)
		// 	fmt.Println(temp)
		// 	temp2 := strings.Join(temp, "")
		// 	if temp2 == s1 {
		// 		return true
		// 	}
		// }
	}
	return false
}

func checkInclusion1(s1 string, s2 string) bool {
	uniqChars := make([]int, 26)

	for i := range s1 {
		uniqChars[s1[i]-'a']++
	}

	currSet := make([]int, 26)

	for i := range s2 {

		currSet[s2[i]-'a']++

		if i >= len(s1) {
			currSet[s2[i-len(s1)]-'a']--
		}
		//fmt.Println(currSet, uniqChars)
		if true == deepEqual(currSet, uniqChars) {
			return true
		}
	}

	return false
}

// func deepEqual(a, b []int) bool {
// 	for i := 0; i < 26; i++ {
// 		if a[i] != b[i] {
// 			return false
// 		}
// 	}
// 	return true
// }
