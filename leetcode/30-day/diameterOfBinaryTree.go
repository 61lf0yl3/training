package main

import (
	"fmt"
)

// func main() {
// 	//s := os.Args[1]
// 	root := &TreeNode{Val: 1}
// 	BTreeInsertData(root, 3)
// 	BTreeInsertData(root, 5)
// 	BTreeInsertData(root, 4)
// 	BTreeInsertData(root, 2)
// 	//BTreeApplyInorder(root, fmt.Println)
// 	//fmt.Println(BTreeLevelCount(root))
// 	fmt.Println("longlengh:", diameterOfBinaryTree(root))
// }

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func diameterOfBinaryTree(root *TreeNode) int {
	var height = 0
	return diameterOpt(root, &height)
}

func diameterOpt(root *TreeNode, height *int) int {
	lh, rh := 0, 0
	ldiameter, rdiameter := 0, 0
	if root == nil {
		*height = 0
		return 0
	}

	ldiameter = diameterOpt(root.Left, &lh)
	rdiameter = diameterOpt(root.Right, &rh)
	fmt.Println("ldiameter:", ldiameter)
	fmt.Println("rdiameter:", rdiameter)
	fmt.Println("lh:", lh)
	fmt.Println("rh:", rh)
	fmt.Println()
	*height = max(lh, rh) + 1
	return max(lh+rh, max(ldiameter, rdiameter))
}

func max(nb1, nb2 int) int {
	if nb1 > nb2 {
		return nb1
	}
	return nb2
}

// func dfs(v *TreeNode, res *int) int {
//     if v == nil {
//         return -1
//     }

//     lh := 1 + dfs(v.Left, res)
//     rh := 1 + dfs(v.Right, res)
//     if *res < lh + rh {
//         *res = lh + rh
//     }

//     if lh < rh {
//         lh = rh
//     }
//     return lh
// }

// func diameterOfBinaryTree(root *TreeNode) int {
//     res := 0
//     dfs(root, &res)
//     return res
// }

func BTreeInsertData(root *TreeNode, data int) *TreeNode {
	if root == nil {
		return &TreeNode{Val: data}
	}

	if data < root.Val {
		root.Left = BTreeInsertData(root.Left, data)
	} else {
		root.Right = BTreeInsertData(root.Right, data)
	}
	return root
}

func BTreeApplyInorder(root *TreeNode, f func(...interface{}) (int, error)) {
	if root != nil {
		BTreeApplyInorder(root.Left, f)
		f(root.Val)
		BTreeApplyInorder(root.Right, f)
	}
	if root == nil {
		return
	}
}
