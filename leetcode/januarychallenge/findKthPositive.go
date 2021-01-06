package januarychallenge

import "fmt"

func FindKthPositive(arr []int, k int) int {
	res := []int{}
	AppendNum(&res, 1, arr[0])
	for i := 0; i < len(arr)-1; i++ {
		if len(res) == k {
			break
		}
		fmt.Println("arr[i]:", arr[i])
		fmt.Println("arr[i+1]:", arr[i+1])
		if arr[i]+1 < arr[i+1] {
			AppendNum(&res, arr[i]+1, arr[i+1])
		}

	}
	if len(res) < k {
		AppendNum(&res, arr[len(arr)-1]+1, arr[len(arr)-1]+1+k-len(res))
	}
	fmt.Println(res)
	return res[k-1]
}

func AppendNum(res *[]int, n1 int, n2 int) {
	for i := n1; i < n2; i++ {
		*res = append(*res, i)
	}
}
