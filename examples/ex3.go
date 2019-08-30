package ex1

//@ prove
//@ pre 1 == 1
//@ post x[0] == x'old[1] && x[1] == x'old[0]
func arrayExample(x []int) {
	var t int
	t = x[0]
	x[0] = x[1]
	x[1] = t
	return
}
