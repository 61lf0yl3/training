package main

// func main() {
// 	arr := []int{1, 2, 3}
// 	//arr := []int{1, 3, 2, 3, 5, 0}
// 	//arr := []int{1, 1, 2, 2}
// 	fmt.Println(countElements(arr))
// }
func countElements(arr []int) int {
	m := make(map[int]bool)
	//sort.Ints(arr)
	for _, l := range arr {
		m[l] = true
	}
	counter := 0
	for _, l := range arr {
		if m[l+1] {
			counter++
		}
	}
	return counter
	// counter := 0
	// for _, l1 := range arr {
	// 	for _, l2 := range arr {
	// 		if l1+1 == l2 {
	// 			counter++
	// 			break
	// 		}
	// 	}
	// }
	// return counter
}
