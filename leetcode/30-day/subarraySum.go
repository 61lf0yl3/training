package main

// func main() {
// 	nums := []int{3, 4, 7, 2, -3, 1, 4, 2}
// 	k := 7
// 	// nums := []int{-1, -1, 1}
// 	// k := 0
// 	// nums := []int{-1, -1, 1}
// 	// k := 2
// 	fmt.Println(subarraySum(nums, k))
// }

func subarraySum(nums []int, k int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	sum, res := 0, 0
	m := make(map[int]int)
	m[0] = 1
	for _, nb := range nums {
		sum += nb
		res += m[sum-k]
		m[sum]++
	}
	return res
}
