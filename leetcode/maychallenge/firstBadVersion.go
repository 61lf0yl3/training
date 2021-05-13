package main

// firstBadVersion
func firstBadVersion(n int) int {
	start := 1
	end := n
	for start < end {
		if isBadVersion(start) {
			return start
		}
		mid := (start + end) / 2
		if mid > 0 { //?
			end = mid
		} else if !isBadVersion(mid) {
			start = mid + 1
		} else {
			start++
		}
	}
	return end
}

func isBadVersion(nb int) bool {
	return true
}
