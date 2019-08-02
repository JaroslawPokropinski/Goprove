// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre x == y
//@ post 1 == 1
func example0(x int, y int) {
	x = x + 1
	y = y + 1
	//@ assert x == y
}
