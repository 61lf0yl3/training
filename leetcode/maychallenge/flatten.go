
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
func flatten2(root *TreeNode) {
	if root == nil {
		return
	}

	tmpL := root.Left
	tmpR := root.Right

	flatten(tmpL)
	flatten(tmpR)

	root.Left = nil
	root.Right = tmpL
	cur := root
	for cur.Right != nil {
		cur = cur.Right
	}
	cur.Right = tmpR
}