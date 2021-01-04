/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(n1 *ListNode, n2 *ListNode) *ListNode {
	iterator2 := n1
	if n2 == nil {
		return n1
	}
	if n1 == nil {
		return n2
	}
	for iterator2 != nil {
		n2 = SortListInsert(n2, iterator2.Val)
		iterator2 = iterator2.Next
	}
	return n2
}

func SortListInsert(l *ListNode, data_ref int) *ListNode {
	n := &ListNode{Val: data_ref}
	if l == nil {
		return n
	}
	if n.Val < l.Val {
		n.Next = l
		return n
	}
	iterator := l
	for iterator.Next != nil && n.Val > iterator.Next.Val {
		iterator = iterator.Next
	}
	n.Next = iterator.Next
	iterator.Next = n
	return l
}

// func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
//     if l1 == nil{
//         return l2
//     }
//     if l2 == nil{
//         return l1
//     }
//     if l1.Val < l2.Val {
//         l1.Next = mergeTwoLists(l1.Next, l2)
//         return l1
//     }else {
//         l2.Next = mergeTwoLists(l2.Next, l1)
//         return l2
//     }
// }