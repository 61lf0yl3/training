package main

// func main() {
// 	// nums := []int{2, 3, 1, 1, 4}
// 	nums := []int{3, 2, 1, 0, 4}
// 	// nums := []int{0, 1}
// 	fmt.Println(canJump(nums))
// }

func canJump(nums []int) bool {
	jump := len(nums) - 1
	for i := len(nums) - 1; i >= 0; i-- {
		if i+nums[i] >= jump {
			jump = i
		} else {
			break
		}
	}
	return jump == 0
}
