package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
	"os/signal"
	"runtime"
	"strconv"
	"syscall"
	"time"
)

func main() {
	stat := make(map[int]int)   // which cores hom much processed url
	sizeCPU := runtime.NumCPU() // number of cores
	runtime.GOMAXPROCS(sizeCPU) // use all cores

	// capture Ctrl+C for print stat
	c := make(chan os.Signal)
	signal.Notify(c, os.Kill, os.Interrupt, syscall.SIGTERM)
	go func() {
		<-c
		fmt.Println()
		for i := 1; i <= sizeCPU; i++ {
			fmt.Println("cores #"+strconv.Itoa(i), "- processed", stat[i], "requests")
		}
		os.Exit(1)
	}()

	// some welcoming text
	fmt.Println("Please paste some urls, then type \"start\" for results!!!")
	fmt.Println("For stitics and exit enter Ctrl+C")

	var input []string                    // strin urls
	scanner := bufio.NewScanner(os.Stdin) //read stdin
	for scanner.Scan() {
		if scanner.Text() == "start" {
			fmt.Println("START")
			urls := make(chan string, len(input)) // channel for send url
			fmt.Println(len(urls))

			// This starts up sizeCPU cores, initially blocked because there are urls no yet.
			for core := 1; core <= sizeCPU; core++ {
				go Worker(core, urls, stat)
			}

			// Send len(input) urls and then close that channel to indicate that’s all the urls we have.
			for _, url := range input {
				urls <- url
			}
			close(urls)
			input = nil
		} else {
			input = append(input, scanner.Text())
		}
	}

	// if err := scanner.Err(); err != nil {
	// 	log.Println(err)
	// }
}

//Worker transient function
func Worker(core int, urls <-chan string, stat map[int]int) {
	for url := range urls {
		stat[core]++
		Kazdream(url)
	}
}

// Kazdream определяет код ответа HTTP на запрос GET, размер документа, и время между отправкой запроса и получением ответа
func Kazdream(url string) {

	//starttime from request
	start := time.Now()

	// make http get request
	resp, err := http.Get(url)
	// endtime to response
	time := time.Since(start).Milliseconds()
	// check for response error
	if err != nil {
		//log.Fatalln(err)
		fmt.Println("Wrong input, please check the input!!!")
	} else {

		// read all response body
		body, _ := ioutil.ReadAll(resp.Body)

		// close response body
		resp.Body.Close()

		fmt.Printf("res: %s;%d;%d;%dms\n", url, resp.StatusCode, len(body), time)
	}
}
