// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre 1 == 1
//@ post (forall p integer !(0 <= p && p < n) || x[p] == y)
func fillExample(x []int, n int, y int) {
	i := 0
	//@ inv (forall q integer !(0 <= q && q < i) || x[q] == y)
	for i < n {
		x[i] = y
	}
	return
}
