package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 3, 5}
	fmt.Println(findErrorNums(nums))
}
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
