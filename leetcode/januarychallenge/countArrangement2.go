package januarychallenge

var count int

// CountArrangement ...
func CountArrangement(n int) int {
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = i + 1
	}
	Check(arr, 0)

	return count
}

func Check(arr []int, j int) {
	if j == len(arr) {
		count++
	}
	for i := j; i < len(arr); i++ {
		Swap(arr, i, j)
		if (arr[j]%(j+1) == 0) || ((j+1)%(arr[j]) == 0) {
			Check(arr, j+1)
		}
		Swap(arr, i, j)
	}
}

func Swap(arr []int, i int, j int) {
	arr[i], arr[j] = arr[j], arr[i]
}
