package decemberchallenge

import "fmt"

// NumPairsDivisibleBy60 ...
func NumPairsDivisibleBy60(time []int) int {
	//timeleft := []int{}
	// for i, v := range time {
	// 	time[i] = v % 60
	// }
	res := 0
	for i1 := 0; i1 < len(time)-1; i1++ {
		for i2 := i1 + 1; i2 < len(time); i2++ {
			//fmt.Println(time[i1], time[i2], "\n")
			if (time[i1]+time[i2])%60 == 0 {
				res++
			}
		}
	}

	fmt.Println(time)
	return res
}
