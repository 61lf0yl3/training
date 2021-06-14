package main

// func main() {
// 	words := []string{"abcd", "dcba", "lls", "s", "sssll"}
// 	fmt.Println(palindromePairs(words))
// }

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

func palindromePairs2(words []string) [][]int {
	res := [][]int{}
	size := len(words)
	if size < 2 {
		return res
	}
	hash := make(map[string]int, size)

	for i := 0; i < size; i++ {
		hash[words[i]] = i
	}

	for i := 0; i < len(words); i++ {
		for k := 0; k <= len(words[i]); k++ {
			right := words[i][k:]
			left := words[i][:k]
			if isPalindrome(right) {
				leftRev := reverse(left)
				if j, ok := hash[leftRev]; ok && i != j {
					res = append(res, []int{i, j})
				}
			}

			if len(left) != 0 && isPalindrome(left) {
				rightRev := reverse(right)
				if j, ok := hash[rightRev]; ok && i != j {
					res = append(res, []int{j, i})
				}
			}
		}
	}

	return res
}

//   func isPalindrome(s string) bool {
// 	i, j := 0, len(s)-1
// 	for i < j {
// 	  if s[i] != s[j] {
// 		return false
// 	  }
// 	  i++
// 	  j--
// 	}
// 	return true
//   }

func reverse(s string) string {
	bs := []byte(s)
	for i, j := 0, len(bs)-1; i < j; i, j = i+1, j-1 {
		bs[i], bs[j] = bs[j], bs[i]
	}
	return string(bs)
}
