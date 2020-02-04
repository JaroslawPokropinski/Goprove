// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre a >= 0 && b >= 0
//@ post c == a'old + b'old
func sum(a int, b int) (c int) {
	c = a + b
	return
}
