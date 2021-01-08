package januarychallenge

func LengthOfLongestSubstring(s string) int {
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
