package decemberchallenge

import "fmt"

// NumPairsDivisibleBy60 ...
func NumPairsDivisibleBy60(time []int) int {
	//timeleft := []int{}
	//fmt.Println(time)
	res := 0
	m := make(map[int]int)
	for _, v := range time {
		//time[i] = v % 60
		m[v%60]++
	}
	fmt.Println(m)
	// for i1 := 0; i1 < len(time)-1; i1++ {
	// 	for i2 := i1 + 1; i2 < len(time); i2++ {
	// 		//fmt.Println(time[i1], time[i2], "\n")
	// 		if (time[i1]+time[i2])%60 == 0 {
	// 			res++
	// 		}
	// 	}
	// }

	return res
}
