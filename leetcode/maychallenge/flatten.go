
//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	node := root
	for node != nil {
		if node.Left != nil {
			tmp := node.Left
			for tmp.Right != nil {
				tmp = tmp.Right
			}
			tmp.Right = node.Right
			node.Right = node.Left
			node.Left = nil
		}
		node = node.Right
	}
}
