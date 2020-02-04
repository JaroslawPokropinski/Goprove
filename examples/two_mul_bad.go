// Błędny algorytm mnożenia razy dwa
package ex1

//@ prove
//@ pre x >= 0
//@ post y == 2 * x'old
func div(x int) (y int) {
	var z int = x
	y = 0
	//@ inv y == 2 * (x - z) && z >= 0
	//@ var z
	for z > 0 {
		z = z - 1
		y = y + 3
	}
	return
}