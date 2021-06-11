type MyCalendar struct {
	books [][]int
}

func Constructor() MyCalendar {
	return MyCalendar{books: [][]int{}}

}

func (this *MyCalendar) Book(start int, end int) bool {
	for _, event := range this.books {
		if event[0] < end && start < event[1] {
			return false
		}
	}
	currectevent := []int{start, end}
	this.books = append(this.books, currectevent)
	return true
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Book(start,end);
 */

type MyCalendar2 struct {
	root *Node
}

type Node2 struct {
	start, end  int
	left, right *Node
}

func Constructor2() MyCalendar {
	return MyCalendar{root: nil}
}

func (this *MyCalendar2) Book2(start int, end int) bool {
	if this.root == nil {
		this.root = &Node2{start: start, end: end, left: nil, right: nil}
		return true
	}
	return this.root.insert(&Node{start: start, end: end, left: nil, right: nil})
}

func (n *Node) insert(node *Node) bool {
	if node.start >= n.end {
		if n.right == nil {
			n.right = node
			return true
		}
		return n.right.insert(node)
	} else if node.end <= n.start {
		if n.left == nil {
			n.left = node
			return true
		}
		return n.left.insert(node)
	}
	return false
}
