package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"time"
)

func worker(id int, jobs <-chan int, results chan<- int, m map[int]int) {
	for j := range jobs {
		m[id]++
		fmt.Println("worker", id, "started  job", j)
		time.Sleep(time.Second)
		fmt.Println("worker", id, "finished job", j)
		results <- j * 2
	}
}

func main() {
	m := make(map[int]int)
	var input []int
	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		if scanner.Text() == "start" {
			fmt.Println("input: ", input)
			numJobs := len(input)
			jobs := make(chan int, numJobs)
			results := make(chan int, numJobs)

			for w := 1; w <= 3; w++ {
				go worker(w, jobs, results, m)
			}

			for _, j := range input {
				jobs <- j
			}
			close(jobs)

			for a := 1; a <= numJobs; a++ {
				<-results
			}
			fmt.Println("map: ", m)
			input = nil
		} else {
			j, _ := strconv.Atoi(scanner.Text())
			input = append(input, j)
		}
	}
	// numJobs := len(input)
	// jobs := make(chan int, numJobs)
	// results := make(chan int, numJobs)

	// for w := 1; w <= 3; w++ {
	// 	go worker(w, jobs, results)
	// }

	// for _, j := range input {
	// 	jobs <- j
	// }
	// close(jobs)

	// for a := 1; a <= numJobs; a++ {
	// 	<-results
	// }
}
