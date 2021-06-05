func openLock(deadends []string, target string) int {
	start := "0000"
	dead := make(map[string]struct{})
	for _, deadend := range deadends {
		dead[deadend] = struct{}{}
	}

	if _, ok := dead[start]; ok {
		return -1
	}
	if target == start {
		return 0
	}

	s1, s2 := 0, 0
	q1, q2 := []string{start}, []string{target}
	m1, m2 := map[string]struct{}{}, map[string]struct{}{}
	m1[start], m2[target] = struct{}{}, struct{}{}

	for len(q1) != 0 && len(q2) != 0 {
		if len(q1) > 0 {
			s1++
		}

		size := len(q1)
		for k := 0; k < size; k++ {
			first := q1[0]
			q1 = q1[1:]
			for i := 0; i < 4; i++ {
				for j := -1; j <= 1; j += 2 {
					next := first
					next = turn(next, i, j)

					if _, ok := m2[next]; ok {
						return s1 + s2
					}

					if _, ok := dead[next]; ok {
						continue
					}

					if _, ok := m1[next]; ok {
						continue
					}

					q1 = append(q1, next)
					m1[next] = struct{}{}
				}
			}
		}

		q1, q2 = q2, q1
		m1, m2 = m2, m1
		s1, s2 = s2, s1
	}

	return -1
}

func turn(s string, i, j int) string {
	b := []byte(s)
	v := int(b[i]-'0') + j
	b[i] = byte((v+10)%10 + '0')
	return string(b)
}