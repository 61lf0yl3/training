package main

// func main() {
// 	s := "(123)"
// }

func ambiguousCoordinates(s string) []string {
	var res []string
	s = s[1 : len(s)-1]
	for i := 1; i < len(s); i++ {
		left, right := valid(s[0:i]), valid(s[i:])
		for _, l := range left {
			for _, r := range right {
				res = append(res, "("+l+", "+r+")")
			}
		}
	}

	return res
}

func valid(s string) []string {
	n := len(s)
	var res []string
	if s[0] == '0' && s[n-1] == '0' {
		if n == 1 {
			res = append(res, "0")
		}
		return res
	}

	if s[0] == '0' {
		res = append(res, "0."+s[1:])
		return res
	}
	if s[n-1] == '0' {
		res = append(res, s)
		return res
	}
	res = append(res, s)
	for i := 1; i < n; i++ {
		res = append(res, s[0:i]+"."+s[i:])
	}

	return res
}

func dec(str string) []string {
	size := len(str)
	if size == 0 {
		return []string{}
	}
	if size == 1 {
		return []string{str}
	}
	if str[0] == '0' && str[size-1] == '0' {
		return []string{}
	}
	if str[size-1] == '0' {
		return []string{str}
	}
	if str[0] == '0' {
		return []string{string(str[0]) + "." + string(str[1:])}
	}
	res := []string{str}
	for i := 1; i < size; i++ {
		res = append(res, string(str[0:i])+"."+string(str[i:]))
	}
	return res
}

func ambiguousCoordinates2(s string) []string {
	str := s[1 : len(s)-1]
	ans := []string{}
	for i := 1; i < len(str); i++ {
		for _, a := range dec(str[0:i]) {
			for _, b := range dec(str[i:]) {
				ans = append(ans, "("+a+", "+b+")")
			}
		}
	}
	return ans
}
