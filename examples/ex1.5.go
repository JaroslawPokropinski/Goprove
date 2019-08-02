// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre x >= 0 && y >= 0
//@ post q*y + r == x && r >= 0 && r < y && x == x'old && y == y'old
func divideWithZero2(x int, y int) (q, r int) {
	q = 0
	r = x
	//@ inv q * y + r == x && r >= 0 && x == x'old && y == y'old
	for r >= y {
		r = r - y
		q = q + 1
	}
	return
}
