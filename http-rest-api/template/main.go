package main

import (
	"html/template"
	"net/http"
)

func main() {
	http.HandleFunc("/", helloWorld)
	http.ListenAndServe(":8081", nil)
}

func helloWorld(w http.ResponseWriter, r *http.Request) {
	name := Name{"Mindorks", "Cheenah"}
	template, _ := template.ParseFiles("hello.html")
	template.Execute(w, name)
}

// Name ...
type Name struct {
	FName, LName string
}
