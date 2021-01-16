package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
	"os/signal"
	"sync"
	"time"

	"golang.org/x/sys/unix"
)

// Stats object for storing stats
type Stats struct {
	stats map[int]int
}

func main() {
	// map to print stats when Ctrl+C is pressed
	stats := make(map[int]int)
	// store request id
	var reqid int

	// mutex to lock map when writing
	// and dont loose data
	mu := &sync.Mutex{}

	// sigchan to capture Ctrl+C
	sigchan := make(chan os.Signal)
	signal.Notify(sigchan, os.Interrupt)
	go func() {
		<-sigchan
		PrintStats(stats)
		os.Exit(0)
	}()

	// scan standart input
	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		url := scanner.Text()

		//increment unque request id
		reqid++

		// open goroutines for each url from input
		go func(url string, reqid int) {

			// unique thread id
			tid := unix.Gettid()

			// send get request and print results
			HTTPGetrequest(url)

			// lock map so other goroutines cant change it
			mu.Lock()
			stats[reqid] = tid
			mu.Unlock()

		}(url, reqid)
	}

}

// HTTPGetrequest send http get request
func HTTPGetrequest(url string) {

	// starting point
	startTime := time.Now()

	// send get request
	resp, err := http.Get(url)

	// time taken for get request
	duration := time.Now().Sub(startTime).Round(time.Millisecond)

	//check get resp for err
	if err != nil {
		fmt.Println(err)
		return
	}
	// body needed for file size
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(fmt.Sprintf("%s;%d;%d;%v", url, resp.StatusCode, len(body), duration))
}

// PrintStats function to print statistics
func PrintStats(stats map[int]int) {
	fmt.Println()
	fmt.Println("Number of processed GET requests:", len(stats))
	for reqid, tid := range stats {
		fmt.Println(fmt.Sprintf("%d:%d", tid, reqid))
	}
}
