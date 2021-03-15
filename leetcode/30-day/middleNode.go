package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	num1 := &ListNode{Val: 1}
	num1 = PushBack(num1, 2)
	num1 = PushBack(num1, 3)
	num1 = PushBack(num1, 4)
	num1 = PushBack(num1, 5)
	num1 = PushBack(num1, 6)

	for tmp := middleNode(num1); tmp != nil; tmp = tmp.Next {
		fmt.Print(tmp.Val)
	}
	fmt.Println()
}

func PushBack(num1 *ListNode, num int) {
	n := &ListNode{Val: num}
	if num1 == nil {
		return
	}
	for tmp := num1; tmp != nil; tmp = tmp.Next {
		tmp.Next = n
	}
	//return num1
}

func middleNode(head *ListNode) *ListNode {
	var newnode *ListNode = head
	// var middle int
	// for tmp := head; tmp != nil; tmp = tmp.Next {
	// 	middle++
	// }
	middle := len(head)
	middle = middle/2 + 1
	counter := 0
	for tmp := head; tmp != nil; tmp = tmp.Next {
		if counter == middle {
			newnode = newnode.Next
			break
		}
		counter++
	}
	return newnode
}

//second way
func middleNode2(head *ListNode) *ListNode {
	fastPtr := head
	slowPtr := fastPtr

	for fastPtr.Next != nil {
		slowPtr = slowPtr.Next

		if fastPtr.Next.Next == nil {
			fastPtr = fastPtr.Next
		} else {
			fastPtr = fastPtr.Next.Next
		}
	}

	return slowPtr
}

func middleNode2(head *ListNode) *ListNode {
	fastPtr := head
	slowPtr := fastPtr

	for fastPtr.Next != nil {
		fmt.Print("fastPtr before:")
		Print(fastPtr)
		fmt.Print("slowPrt before ")
		Print(slowPtr)
		slowPtr = slowPtr.Next
		fmt.Print("slowPrt after:")
		Print(slowPtr)

		if fastPtr.Next.Next == nil {
			fastPtr = fastPtr.Next
			fmt.Print("fastPtr after if1:")
			Print(fastPtr)
		} else {
			fastPtr = fastPtr.Next.Next
			fmt.Print("fastPtr ter if2:")
			Print(fastPtr)
		}
	}

	return slowPtr
}

func Print(num1 *ListNode) {
	for tmp := num1; tmp != nil; tmp = tmp.Next {
		fmt.Print(tmp.Val)
	}
	fmt.Println()
}
