//change date !!!!
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	res := &TreeNode{
		Val: preorder[0],
	}
	if len(preorder) == 1 {
		return res
	}
	idx := func(val int, nums []int) int {
		for i, v := range nums {
			if v == val {
				return i
			}
		}
		return -1
	}(res.Val, inorder)
	if idx == -1 {
		return nil
	}
	res.Left = buildTree(preorder[1:idx+1], inorder[:idx])
	res.Right = buildTree(preorder[idx+1:], inorder[idx+1:])
	return res
}

func buildTree2(preorder []int, inorder []int) *TreeNode {
	inPos := make(map[int]int, len(inorder))

	for i := range inorder {
		inPos[inorder[i]] = i
	}
	return help(preorder, 0, len(preorder)-1, 0, inPos)
}

func help(pre []int, preStart, preEnd, inStart int, inPos map[int]int) *TreeNode {
	if preStart > preEnd {
		return nil
	}
	root := &TreeNode{Val: pre[preStart]}
	rootIndex := inPos[pre[preStart]]
	preLength := rootIndex - inStart
	root.Left = help(pre, preStart+1, preStart+preLength, inStart, inPos)
	root.Right = help(pre, preStart+preLength+1, preEnd, rootIndex+1, inPos)

	return root
}
