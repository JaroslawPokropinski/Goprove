// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre 1 == 1
//@ post (j >= 0 || i == 1) && (j < 0 || i == 2)
func ifExample(j int) (i int) {
	i = 0

	if j < 0 {
		i = 1
	}

	if j >= 0 {
		i = 2
	}

	return
}
