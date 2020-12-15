package novemberchallenge

func maxPower(s string) int {
	res := 0
	temp := 0
	for i, v := range s {
		if i == 0 {
			res, temp = 1, 1
			continue
		}
		if v == rune(s[i-1]) {
			temp++
			if temp > res {
				res = temp
			}
		} else if v != rune(s[i-1]) {
			temp = 1
		}

	}
	return res
}
