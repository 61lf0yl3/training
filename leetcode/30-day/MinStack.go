package main

// func main() {

// }

type MinStack struct {
	stack []Item
	min   int
}

type Item struct {
	val, prev int
}

func Constructor() MinStack {
	return MinStack{}
}

func (this *MinStack) Push(x int) {
	item := Item{val: x, prev: this.min}
	if len(this.stack) == 0 || x < this.min {
		this.min = x
	}
	this.stack = append(this.stack, item)
}

func (this *MinStack) Pop() {
	last := this.stack[len(this.stack)-1]
	if this.min == last.val {
		this.min = last.prev
	}
	this.stack = this.stack[:len(this.stack)-1]
}

func (this *MinStack) Top() int {
	return this.stack[len(this.stack)-1].val
}

func (this *MinStack) GetMin() int {
	return this.min
}
