package main

//Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedListToBST(head *ListNode) *TreeNode {
	var rootVal int
	var rootindex int
	headarr := []int{}
	for e := head; e != nil; e = e.Next {
		headarr = append(headarr, e.Val)
	}
	if len(headarr)%2 == 0 {
		rootindex = (len(headarr) / 2) - 1
		rootVal = headarr[(len(headarr)/2)-1]
	} else {
		rootindex = len(headarr) / 2
		rootVal = headarr[len(headarr)/2]
	}
	root := &TreeNode{Val: rootVal}
	//arr1 := headarr[0:rootindex]
	arr2 := headarr[rootindex+1 : len(headarr)]
	//fmt.Println(arr1, arr2)
	for i := rootindex - 1; i >= 0; i-- {
		BTreeInsertData(root, headarr[i])
	}
	for _, val := range arr2 {
		BTreeInsertData(root, val)
	}
	return root
}

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
