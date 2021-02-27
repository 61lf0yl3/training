package main

import (
	"fmt"
	"sort"
	"strings"
)

// func main() {
// 	strs := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
// 	//strs := []string{"abc", "cab", "bca"}
// 	fmt.Println(groupAnagrams(strs), "\n")
// 	//fmt.Println(groupAnagrams(strs1))
// }

func groupAnagrams(strs []string) [][]string {
	m := make(map[string][]string)
	result := [][]string{}
	for _, val := range strs {
		fmt.Println("val:", val)
		strArr := strings.Split(val, "") //make slice of string
		fmt.Println("strArr:", strArr)
		sort.Strings(strArr) //sort the slice of string
		fmt.Println("sort.String(strArr):", strArr)
		sortedString := strings.Join(strArr, "") //make a string again
		fmt.Println("sortedString:", sortedString)
		fmt.Println("map:", m)
		m[sortedString] = append(m[sortedString], val)
		fmt.Println("map:", m)
	}
	for _, value := range m {
		result = append(result, value)
	}
	return result
}

func groupAnagrams2(strs []string) [][]string {
	var res = [][]string{}
	for i1 := 0; i1 < len(strs); i1++ {
		var group = []string{}
		str := strs[i1]
		group = append(group, str)
		//word1 := []rune(str)
		//Sort(word1)
		word1 := strings.Split(str, "")
		sort.Strings(word1)
		word1str := strings.Join(word1, "")
		for i2 := i1 + 1; i2 < len(strs); i2++ {
			//word2 := []rune(strs[i2])
			//Sort(word2)
			word2 := strings.Split(strs[i2], "")
			sort.Strings(word2)
			word2str := strings.Join(word2, "")
			//if string(word1) == string(word2) {
			if word1str == word2str {
				group = append(group, strs[i2])
				strs = append(strs[:i2], strs[i2+1:]...)
				i2--
			}
		}
		res = append(res, group)
	}
	return res
}

func Sort(str []rune) {
	for i1 := range str {
		for i2 := range str {
			if str[i1] > str[i2] {
				str[i1], str[i2] = str[i2], str[i1]
			}
		}
	}
}
