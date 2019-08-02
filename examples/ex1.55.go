// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre x >= 0 && y >= 0
//@ post q*y + r == x && r >= 0 && r < y
func divideWithZero3(x int, y int) (q, r int) {
	var a int
	var b int
	a = x
	b = y
	q = 0
	r = a
	//@ inv q * b + r == a && r >= 0 && x == a && y == b
	for r >= b {
		r = r - b
		q = q + 1
	}
	return
}
