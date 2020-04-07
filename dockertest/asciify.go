package ascii

import (
	"io/ioutil"
	"strings"
)

func Asciify(args []string) (string, error) {
	var result string
	var m = make(map[rune]string)
	var err error
	var data []byte
	if args[1] == "shadow" {
		data, err = ioutil.ReadFile("shadow.txt")
	} else if args[1] == "thinkertoy" {
		data, err = ioutil.ReadFile("thinkertoy.txt")
	} else {
		data, err = ioutil.ReadFile("standard.txt")
	}
	if err != nil {
		return "", err
	}
	var res string
	var counter int
	runeit := ' '
	for _, l := range data {
		if counter > 0 && counter < 8 {
			res += string(l)
		}
		if counter == 8 && l != 10 {
			res += string(l)
		}
		if l == 10 { // if rune = newline
			counter++
		}
		if counter == 9 { // number of newlines
			m[runeit] = res
			runeit++
			counter = 0
			res = ""
		}
	}
	var counter2 int
	for _, l2 := range strings.Split(args[0], "\\n") {
		for i1 := 0; i1 < 8; i1++ {
			for _, l3 := range l2 {
				result += printLine(m[l3], i1)
				counter2++
			}
			//	if counter2 < 15 {
			result += string(10)
			//}
		}
	}
	return result, err
}
func printLine(maps string, line int) string {
	var res string
	counter := 0
	for _, l3 := range maps {
		if l3 == '\n' {
			counter++
		}
		if counter > line {
			return res
		}
		if counter == line {
			if l3 != '\n' {
				res += string(l3)
			}
		}
	}
	return res
}
