package januarychallenge

//my own solution
func LengthOfLongestSubstring1(s string) int {
	ascii := make([]int, 127)
	counter1 := 0
	for i := 0; i < len(s); i++ {
		if ascii[int(rune(s[i]))] == 1 {

		} else if ascii[int(rune(s[i]))] == 0 {
			ascii[int(rune(s[i]))] = 1
			counter1++
		}

	}
	return counter1
}

// LengthOfLongestSubstring my own solution2
func LengthOfLongestSubstring(s string) int {
	start := 0
	res := 0
	m := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		end := i
		elem, ok := m[s[i]]
		if !ok {
			m[s[i]] = i
		} else if ok {
			if elem+1 >= start {
				start = elem + 1
			}
			m[s[i]] = i
		}
		if res < end-start+1 {
			res = end - start + 1
		}

	}
	return res
}

// leetcode solution
func lengthOfLongestSubstring3(s string) int {
	data := make(map[byte]int)
	var ret, i, j int
	for j < len(s) {
		if v, ok := data[s[j]]; ok {
			ret = max(ret, len(s[i:j]))
			i = max(i, v+1)
		}
		data[s[j]] = j
		j += 1
	}
	return max(ret, len(s[i:j]))

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
