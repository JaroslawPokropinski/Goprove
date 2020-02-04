package main

import (
	"fmt"
	"mysort"
)

func main() {
	array := [4]int{4, 3, 2, 1}
	mysort.Sort(array, len(array))
	for i := 0; i < 4; i++ {
		fmt.Println(array[i])
	}
	fmt.Println("Hello, world.")
}
