package novemberchallenge

// InsertionSortList ...
func insertionSortList(head *ListNode) *ListNode {
	node := &ListNode{}

	for head != nil {
		for node != nil {
			if head.Val > node.Val {
				node.Val, head.Val = head.Val, node.Val
			}
			node = node.Next
		}
		head = head.Next
	}

	return node
}
