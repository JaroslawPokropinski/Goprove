// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre 1 == 1
//@ post (forall l integer !(1 <= l && l < n) || x[l - 1] <= x[l])
func sortExample(x []int, n int) {
	i := 1
	//@ inv (forall r integer !(1 <= r && r < i) || x[r - 1] <= x[r])
	for i < n {
		j := i
		//@ inv (forall p integer !(1 <= p && p < j) || x[p - 1] <= x[p]) && (forall q integer !(j < q && q < i) || x[q - 1] <= x[q])
		for j > 0 && x[j-1] > x[j] {
			t := x[j]
			x[j] = x[j-1]
			x[j-1] = t
			j = j - 1
		}
		i = i + 1
	}
	return
}
