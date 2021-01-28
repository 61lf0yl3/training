package januarychallenge

import (
	"strings"
)

// ArrayStringsAreEqual ...
func ArrayStringsAreEqual(word1 []string, word2 []string) bool {
	word1str := strings.Join(word1, " ")
	word2str := strings.Join(word2, " ")
	// fmt.Println(word1str)
	// fmt.Println(word2str)
	return true
	return strings.Join(word1, "") == strings.Join(word2, "")
}
