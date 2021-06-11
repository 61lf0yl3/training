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