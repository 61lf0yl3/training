package main

// func main() {
// 	prices := []int{7, 1, 5, 3, 6, 4}
// 	//prices := []int{1, 2, 3, 4, 5}
// 	//prices := []int{7, 6, 4, 3, 1}
// 	fmt.Println(maxProfit(prices))
// }

func maxProfit(prices []int) int {
	var maxprofit = 0
	if len(prices) <= 1 {
		return maxprofit
	}
	for i := 0; i < len(prices); i++ {
		if i > 0 && prices[i] > prices[i-1] {
			maxprofit += prices[i] - prices[i-1]
		}
	}
	return maxprofit
}
