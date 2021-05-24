package main

// func main() {
// 	a := []string{"A", "B", "C", "D", "E"}
// 	a = nil
// 	fmt.Println(a, len(a), cap(a))
// 	a = append(a, "A")
// 	fmt.Println(a, len(a), cap(a))
// }

func numSubarrayBoundedMax(nums []int, left int, right int) int {
	start := -1
	end := -1
	res := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] > right {
			start = i
			end = i
			continue
		}
		if nums[i] >= left {
			end = i
		}
		res += end - start
		//fmt.Println("res:", res)
	}
	return res
}

func numSubarrayBoundedMax2(nums []int, left int, right int) int {
	return getAnswerPerBound(nums, right) - getAnswerPerBound(nums, left-1)
}

func getAnswerPerBound(nums []int, bound int) int {
	res, count := 0, 0
	for _, num := range nums {
		if num <= bound {
			count++
		} else {
			count = 0
		}
		res += count
	}
	return res
}
