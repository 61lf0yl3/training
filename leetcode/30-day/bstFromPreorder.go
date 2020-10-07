package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	preorder := []int{8, 5, 1, 7, 10, 12}
	bstFromPreorder(preorder)
}
func bstFromPreorder(preorder []int) *TreeNode {
	root := &TreeNode{Val: preorder[0]}
	for i, l := range preorder {
		if i > 0 {
			BTreeInsertData(root, l)
		}
	}
	return root
}

func BTreeInsertData(root *TreeNode, data int) *TreeNode {
	if root == nil {
		return &TreeNode{Val: data}
	}

	if data < root.Val {
		root.Left = BTreeInsertData(root.Left, data)
		//root.Left.Parent = root
	} else {
		root.Right = BTreeInsertData(root.Right, data)
		//root.Right.Parent = root
	}
	return root
}
