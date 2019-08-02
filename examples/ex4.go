// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre true
//@ post (forall i integer 0 < i && i < len(x) && x[i - 1] <= x[i])
func sortExample(x []int) {
	i := 1
	for i < len(x) {
		j := i
		//@ inv (forall k integer 0 < k && k < i - 1 && x[k - 1] <= x[k])
		for j > 0 && x[j-1] > x[j] {
			t := x[j]
			x[j] = x[j-1]
			x[j-1] = t
			j = j - 1
		}
		i = i - 1
	}
	return
}
