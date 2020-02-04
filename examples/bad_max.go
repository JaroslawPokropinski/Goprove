// Przykład prezentujący funkcję zwracającą sumę wartości bezwzględnych element tablicy.
package ex1

//@ prove
//@ pre n > 0
//@ post (forall x integer !(x >= 0 && x < n) || max >= a[x] )
func badMax(a []int, n int) (max int) {
	max = 0	
	var i int = 0
	//@ inv (forall y integer !(y >= 0 && y < i) || max >= a[y]) && max >= 0 && i <= n
	//@ var n - i
	for i < n {
		if (a[i] > 0) {
			max = max + a[i]
		} else {
			max = max - a[i]
		}
		i = i + 1
	}
	return
}