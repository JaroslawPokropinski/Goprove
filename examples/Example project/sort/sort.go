package mysort

//@ prove
//@ pre 1 == 1
//@ post (forall k integer !(1 <= k && k < n) || x[k - 1] <= x[k])
func Sort(x []int, n int) {
	var i int = 1
	//@ inv (forall k integer !(1 <= k && k < i) || x[k - 1] <= x[k])
	for i < n {
		var j int = i
		//@ inv (forall k integer !(k >= 1 && k <= j-1) || x[k - 1] <= x[k]) && (forall k integer !(k >= j + 1 && k <= i) || x[k - 1] <= x[k]) && (!(j < i) || x[j-1] <= x[j+1]) && j <= i
		for j > 0 && x[j-1] > x[j] {
			var t int = x[j]
			//@ assert x[j-2] <= x[j-1]
			x[j] = x[j-1]
			x[j-1] = t
			j = j - 1
			//@ assert (forall k integer !(k >= 1 && k <= j-1) || x[k - 1] <= x[k])
			//@ assert (forall k integer !(k >= j + 1 && k <= i) || x[k - 1] <= x[k])
			//@ assert j < i
		}
		i = i + 1
	}
	return
}
