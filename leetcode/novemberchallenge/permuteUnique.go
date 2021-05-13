package novemberchallenge

import "sort"

// permuteUnique ...
func permuteUnique(nums []int) [][]int {
	n := len(nums)
	if n == 0 {
		return nil
	}
	if n == 1 {
		return [][]int{nums}
	}
	var rst [][]int
	sort.Ints(nums)
	head := nums[0]
	rest := nums[1:]
	restPermutations := permuteUnique(rest)
	for _, onePermutation := range restPermutations {
		pos := 0
		if head == rest[0] {
			pos = findLast(head, onePermutation)
		}
		allNums := insertAt(pos, head, onePermutation)
		rst = append(rst, allNums...)
	}
	return rst
}

// findLast ...
func findLast(elem int, arr []int) int {
	for i := len(arr) - 1; i >= 0; i-- {
		if arr[i] == elem {
			return i + 1
		}
	}
	return -1
}

// insertAt ...
func insertAt(at int, elem int, arr []int) [][]int {
	n := len(arr)
	rst := make([][]int, n-at+1)
	for i := at; i <= n; i++ {
		withNewElem := make([]int, n+1)
		copy(withNewElem, arr[0:i])
		withNewElem[i] = elem
		copy(withNewElem[i+1:], arr[i:])
		rst[i-at] = withNewElem
	}
	return rst
}
