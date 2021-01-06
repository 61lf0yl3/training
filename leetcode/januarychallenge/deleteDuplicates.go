/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
// func PrintList(l *ListNode) {
// 	it := l
// 	for it != nil {
// 		fmt.Print(it.Val, " -> ")
// 		it = it.Next
// 	}
// 	fmt.Print(nil, "\n")
// }

// func deleteDuplicates(n1 *ListNode) *ListNode {
// 	iterator := n1
// 	if iterator == nil {
// 		return n1
// 	}
//     copy := FindCopy(iterator)
// 	for iterator != nil {
//         fmt.Println("iterator.Val:", iterator.Val)
//         fmt.Println("iterator.Next.Val:", iterator.Next.Val)
//         fmt.Println("before copy:", copy)

//         if iterator.Next != nil && copy == iterator.Next.Val {
//             Remove(n1, iterator.Next.Val)
//             //copy = iterator.Next.Val
//         } else if iterator.Next != nil && copy != iterator.Next.Val {
//             Remove(n1, copy)
//             copy = iterator.Next.Val
//         }

//         fmt.Println("after copy:", copy)
//         fmt.Printf("list:")
//         PrintList(n1)
//         fmt.Println()

// 		iterator = iterator.Next
// 	}
// 	return n1
// }

// func FindCopy(n *ListNode) int {
//     copy := -1
//     head := n
// 	for head != nil {
//         if head.Next != nil && head.Val == head.Next.Val  {
// 		    copy = head.Next.Val
// 		}
// 		head = head.Next
// 	}
// 	return copy
// }

// func Remove(n *ListNode, val int) *ListNode {
// 	head := n
// 	for head.Next != nil {
// 		if head.Next.Val == val {
// 			head.Next = head.Next.Next
// 			return head
// 		}
// 		head = head.Next
// 	}
// 	return head
// }

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return head
	}

	nilNode := &ListNode{Val: 0, Next: head}
	head = nilNode

	lastVal := 0
	for head.Next != nil && head.Next.Next != nil {
		if head.Next.Val == head.Next.Next.Val {
			lastVal = head.Next.Val
			for head.Next != nil && lastVal == head.Next.Val {
				head.Next = head.Next.Next
			}
		} else {
			head = head.Next
		}
	}
	return nilNode.Next
}

