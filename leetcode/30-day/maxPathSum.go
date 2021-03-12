package main

import "math"

// type TreeNode struct {
// 	Val   int
// 	Left  *TreeNode
// 	Right *TreeNode
// }

// TreeNode(item int)  {
// }

func maxPathSum(root *TreeNode) int {
	var res int = math.MinInt32
	findMaxUtil(root, res)
	return res
}

func findMaxUtil(root *TreeNode, res int) int {
	if root == nil {
		return 0
	}
	var l int = findMaxUtil(root.Left, res)
	var r int = findMaxUtil(root.Right, res)

	var maxsingle int = Max(Max(l, r)+root.Val, root.Val)

	var maxtop int = Max(maxsingle, l+r+root.Val)
	res = Max(res, maxtop)

	return res
}

func Max(nb1, nb2 int) int {
	if nb1 > nb2 {
		return nb1
	}
	return nb2
}
