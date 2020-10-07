package main

type FirstUnique struct {
	arr []int
}

func Constructor(nums []int) FirstUnique {
	FirstUnique.arr = nums
}

func (this *FirstUnique) ShowFirstUnique() int {

}

func (this *FirstUnique) Add(value int) {
	this.arr = append(this.arr, value)
}
