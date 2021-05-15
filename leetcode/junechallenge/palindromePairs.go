package main

import "fmt"

func main() {
	words := []string{"abcd", "dcba", "lls", "s", "sssll"}
	fmt.Println(palindromePairs(words))
}

func palindromePairs(words []string) [][]int {
	res := [][]int{}
	for i := 0; i < len(words); i++ {
		for j := 0; j < len(words); j++ {
			if i == j {
				continue
			}
			if isPalindrome(words[i] + words[j]) {
				res = append(res, []int{i, j})
			}
		}
	}
	return res
}

func isPalindrome(input string) bool {
	for i := 0; i < len(input)/2; i++ {
		if input[i] != input[len(input)-i-1] {
			return false
		}
	}
	return true
}
