// Dzielenie liczb naturalnych
package ex1

//@ prove
//@ pre x >= 0 && y >= 0
//@ post q*y + r == x'old && r >= 0 && r < y'old
func div(x int, y int) (q, r int) {
	q = 0
	r = x
	//@ inv y > 0 && q * y + r == x && r >= 0
	//@ var r
	for r >= y {
		r = r - y
		q = q + 1
	}
	return
}
