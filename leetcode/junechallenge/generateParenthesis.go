package main

// func main() {

// }

func generateParenthesis(n int) []string {
	res := []string{}
	backTrack(0, 0, n, "", &res)
	return res

}
func backTrack(openParenthesis, closeParenthesis, n int, output string, res *[]string) {
	if openParenthesis == closeParenthesis && openParenthesis == n {
		*res = append(*res, output)
		return
	}
	if openParenthesis < n {
		backTrack(openParenthesis+1, closeParenthesis, n, output+"(", res)
	}
	if closeParenthesis < openParenthesis {
		backTrack(openParenthesis, closeParenthesis+1, n, output+")", res)
	}
	return
}

func backTrack2(left, right, n int, s string, res *[]string) {
	if left == right && left == n {
		*res = append(*res, s)
	} else if left >= right && left <= n && right <= n {
		new := s
		backTrack(left+1, right, n, new+"(", res)
		backTrack(left, right+1, n, new+")", res)
	}
}
