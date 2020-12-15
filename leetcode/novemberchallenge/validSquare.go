package novemberchallenge

func validSquare(p1 []int, p2 []int, p3 []int, p4 []int) bool {
	if p1[0] == p2[0] && p1[1] == p2[1] || p1[0] == p3[0] && p1[1] == p3[1] || p1[0] == p4[0] && p1[1] == p4[1] {
		return false
	}

	p1p2 := distance(p1, p2)
	p1p3 := distance(p1, p3)
	p1p4 := distance(p1, p4)

	if p1p2 == p1p3 {
		p2p3 := distance(p2, p3)
		p3p4 := distance(p3, p4)
		if p1p4 == p2p3 && p1p2 == p3p4 {
			return true
		}
	}
	if p1p2 == p1p4 {
		p2p4 := distance(p2, p4)
		p4p3 := distance(p4, p3)
		if p1p3 == p2p4 && p1p2 == p4p3 {
			return true
		}
	}
	if p1p3 == p1p4 {
		p3p4 := distance(p3, p4)
		p4p2 := distance(p4, p2)
		if p1p2 == p3p4 && p1p3 == p4p2 {
			return true
		}
	}
	return false
}

func distance(p1 []int, p2 []int) int {
	dis := poweroftwo(p1[0]-p2[0]) + poweroftwo(p1[1]-p2[1])
	return dis
}

func poweroftwo(nb int) int {
	return nb * nb
}
