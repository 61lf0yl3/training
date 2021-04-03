package main

// func main() {
// 	nums := []int{1, 2, 3, 3, 5}
// 	fmt.Println(findErrorNums(nums))
// }
func findErrorNums(nums []int) []int {
	if len(nums) == 2 {
		nums[1]++
		return nums
	}
	res := []int{}
	m := make(map[int]int)
	for i, v := range nums {
		m[v]++
		if m[v] == 2 {
			res = append(res, nums[i-1])
			res = append(res, v)
			res = append(res, nums[i+1])
			break
		}
	}
	//fmt.Println(res)
	if res[2]-res[1] == 1 {
		res[0]--
		res = res[:2]
		return res
	} else {
		res[2]--
		res = res[1:]
		return res
	}
}
func findErrorNums2(nums []int) []int {

	dup := 0
	for i := 0; i < len(nums); i++ {
		n := abs(nums[i])

		if nums[n-1] < 0 {
			dup = n
			// NOTICE: nums[n-1]<0 的时候，不能再取反为正数了
		} else {
			nums[n-1] = -nums[n-1]
		}
	}

	mis := 0
	for i, v := range nums {
		if v > 0 {
			mis = i + 1
			break
		}
	}

	return []int{dup, mis}
}

func abs(a int) int {
	if a > 0 {
		return a
	}
	return -a
}
