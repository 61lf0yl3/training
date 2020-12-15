package novemberchallenge

//ListNode ...
type ListNode struct {
	Val  int
	Next *ListNode
}

func getDecimalValue(head *ListNode) int {
	var res int
	for head != nil {
		res = res*2 + head.Val
		head = head.Next
	}
	return res
}

// func getDecimalValue(head *ListNode) int {
//     ret := 0
//     for head != nil {
//         ret = ret << 1
//         ret |= head.Val
//         head = head.Next
//     }
//     return ret
// }
