package main

import "fmt"

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
	if head == nil {
		return nil
	}
	var rootVal int
	headarr := []int{}
	for e := head; e != nil; e = e.Next {
		headarr = append(headarr, e.Val)
	}
	rootVal = headarr[len(headarr)/2]
	fmt.Println(rootVal)
	root := &TreeNode{Val: rootVal}
	for i := len(headarr) - 1; i >= 0; i-- {
		if rootVal != headarr[i] {
			BTreeInsertData(root, headarr[i])
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
	} else {
		root.Right = BTreeInsertData(root.Right, data)
	}
	return root
}
