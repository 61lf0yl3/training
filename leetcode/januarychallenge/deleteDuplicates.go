package januarychallenge

import "fmt"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

// PrintList ...
func PrintList(l *ListNode) {
	it := l
	for it != nil {
		fmt.Print(it.Val, " -> ")
		it = it.Next
	}
	fmt.Print(nil, "\n")
}

func deleteDuplicates(n1 *ListNode) *ListNode {
	iterator := n1
	if iterator == nil {
		return n1
	}
	copy := FindCopy(iterator)
	for iterator != nil {
		fmt.Println("iterator.Val:", iterator.Val)
		fmt.Println("iterator.Next.Val:", iterator.Next.Val)
		fmt.Println("before copy:", copy)

		if iterator.Next != nil && copy == iterator.Next.Val {
			Remove(n1, iterator.Next.Val)
			//copy = iterator.Next.Val
		} else if iterator.Next != nil && copy != iterator.Next.Val {
			Remove(n1, copy)
			copy = iterator.Next.Val
		}

		fmt.Println("after copy:", copy)
		fmt.Printf("list:")
		PrintList(n1)
		fmt.Println()

		iterator = iterator.Next
	}
	return n1
}

func FindCopy(n *ListNode) int {
	copy := -1
	head := n
	for head != nil {
		if head.Next != nil && head.Val == head.Next.Val {
			copy = head.Next.Val
		}
		head = head.Next
	}
	return copy
}

func Remove(n *ListNode, val int) *ListNode {
	head := n
	for head.Next != nil {
		if head.Next.Val == val {
			head.Next = head.Next.Next
			return head
		}
		head = head.Next
	}
	return head
}

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	nilNode := &ListNode{Val: 0, Next: head}

	lastIsDel := false

	//     fmt.Printf("before head: ")
	//     PrintList(head)

	//     fmt.Printf("before nilNode: ")
	//     PrintList(nilNode)

	head = nilNode

	//     fmt.Printf("after head: ")
	//     PrintList(head)

	//     fmt.Printf("after nilNode: ")
	//     PrintList(nilNode)

	pre, back := head.Next, head.Next.Next

	for head.Next != nil && head.Next.Next != nil {
		fmt.Printf("enter head: ")
		PrintList(head)

		fmt.Println("head.Val:", head.Val)
		fmt.Println("pre.Val:", pre.Val)
		fmt.Println("back.Val:", back.Val)

		if pre.Val != back.Val && lastIsDel {
			fmt.Println("first condition")
			fmt.Println()
			head.Next = head.Next.Next
			pre, back = head.Next, head.Next.Next
			lastIsDel = false
			continue
		}

		if pre.Val == back.Val {
			fmt.Println("second condition")
			fmt.Println()
			// fmt.Printf("before head: ")
			// PrintList(head)

			head.Next = head.Next.Next

			// fmt.Printf("after head: ")
			// PrintList(head)

			pre, back = head.Next, head.Next.Next
			lastIsDel = true
		} else {
			fmt.Println("third condition")
			fmt.Println()
			head = head.Next
			pre, back = head.Next, head.Next.Next
			lastIsDel = false
		}
	}

	if lastIsDel && head.Next != nil {
		head.Next = nil
	}
	return nilNode.Next
}
