package main

// func main() {
// 	ransomNote := "aaa"
// 	magazine := "aaab"
// 	fmt.Println(canConstruct(ransomNote, magazine))
// }

//canConstruct
func canConstruct(ransomNote string, magazine string) bool {
	if len(ransomNote) == 0 {
		return true
	}
	if len(ransomNote) > len(magazine) {
		return false
	}

	m := make(map[rune]int)
	for _, l := range magazine {
		m[l]++
	}
	//fmt.Println("m:", m)
	for _, l := range ransomNote {
		//fmt.Println("m:", m)
		value, ok := m[l]
		if !ok {
			return false
		}
		if ok {
			if value == 1 {
				delete(m, l)
			} else if value > 1 {
				m[l]--
			}
		}
	}
	return true
}
