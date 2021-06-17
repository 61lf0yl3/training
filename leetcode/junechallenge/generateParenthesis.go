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
