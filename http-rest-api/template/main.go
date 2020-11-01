package main

import (
	"fmt"
	"html/template"
	"os"
)

func main() {
	fmt.Println("Template")
	template, _ := template.ParseFiles("hello.html")
	template.Execute(os.Stdout, "Boruto")
}
