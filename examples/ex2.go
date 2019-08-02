// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre x >= 0 && y >= 0
//@ post q*y + r == x && r >= 0 && r < y
func example(x int, y int) (q, r int) {
	q = 0
	r = x
	//@ inv q * y + r == x && r >= 0
	for r >= y && (r >= y || r >= y) {
		r = r - y
		q = q + 1
	}
	//@ assert q*y + r == x && r >= 0 && r < y
	return
}
