func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordListHashSet := make(map[string]bool)

	for _, v := range wordList {
		wordListHashSet[v] = true
	}

	queue := []string{beginWord}
	var ladder int

	for len(queue) > 0 {
		levelsize := len(queue)
		ladder += 1

		for k := 0; k < levelsize; k++ {
			word := queue[0]
			queue = queue[1:]

			for i := 0; i < len(word); i++ {
				curr := []byte(word)
				temp := word

				for j := 'a'; j <= 'z'; j++ {
					curr[i] = byte(j)
					word = string(curr)

					if wordListHashSet[word] {
						queue = append(queue, word)
						delete(wordListHashSet, word)

						if word == endWord {
							return ladder + 1
						}
					}
				}
				word = temp
			}
		}

	}

	return 0
}