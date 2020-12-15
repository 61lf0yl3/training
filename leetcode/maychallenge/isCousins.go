package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isCousins(root *TreeNode, x int, y int) bool {
	return ((BtreeLevel(root, x, 1) == BtreeLevel(root, y, 1)) && !Sibling(root, x, y))
}

func BtreeLevel(root *TreeNode, child int, level int) int {
	if root == nil {
		return 0
	}
	if root.Val == child {
		return level
	}
	l := BtreeLevel(root.Left, child, level+1)
	if l != 0 {
		return l
	}
	return BtreeLevel(root.Right, child, level+1)
}

func Sibling(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}
	return ((root.Left.Val == x && root.Left.Val == y) ||
		(root.Left.Val == y && root.Right.Val == x) ||
		Sibling(root.Left, x, y) || Sibling(root.Right, x, y))
}
