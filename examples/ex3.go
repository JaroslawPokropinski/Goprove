package ex1

//@ prove
//@ pre true
//@ post x[0] == x'old[1] && x[1] == x'old[0]
func arrayExample(x []int) {
	t := x[0]
	x[0] = x[1]
	x[1] = t
	return
}
