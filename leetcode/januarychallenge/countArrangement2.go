package januarychallenge

var count int

func countArrangement(n int) int {
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = i + 1
	}
	check(arr, 0)

	return count
}

func check(arr []int, j int) {
	if j == len(arr) {
		count++
	}
	for i := j; i < len(arr); i++ {
		swap(arr, i, j)
		if (arr[j]%(j+1) == 0) || ((j+1)%(arr[j]) == 0) {
			check(arr, j+1)
		}
		swap(arr, i, j)
	}
}

func swap(arr []int, i int, j int) {
	arr[i], arr[j] = arr[j], arr[i]
}
