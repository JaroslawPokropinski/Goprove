// Przykład prezentujący funkcję zwracającą maksymalny element tablicy.
package ex1

//@ prove
//@ pre n > 0
//@ post (forall x integer !(x >= 0 && x < n) || max >= a[x] ) && (exists x integer x >= 0 && x < n && max == a[x])
func max(a []int, n int) (max int) {
	max = a[0]
	var i int = 1
	//@ inv (forall y integer !(y >= 0 && y < i) || max >= a[y]) && (exists x integer x >= 0 && x < i && max == a[x]) && i <= n
	//@ var n - i
	for i < n {
		if (max < a[i]) {
			max = a[i]
		}
		i = i + 1
	}
	return
}