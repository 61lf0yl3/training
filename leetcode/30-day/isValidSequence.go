package main

// func main() {}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isValidSequence(root *TreeNode, arr []int) bool {
	return checkValidity(root, arr, 0)
}

func checkValidity(root *TreeNode, arr []int, index int) bool {
	if root == nil || index >= len(arr) {
		return false
	}
	if root.Left == nil && root.Right == nil {
		return root.Val == arr[index] && index == len(arr)-1
	}
	if root.Val == arr[index] {
		return checkValidity(root.Left, arr, index+1) || checkValidity(root.Right, arr, index+1)
	}
	return false
}
