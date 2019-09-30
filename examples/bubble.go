// Package ex1 showing basic functionality of framework
package ex1

//@ prove
//@ pre 1 == 1
//@ post (forall k integer !(1 <= k && k < n) || x[k - 1] <= x[k])
func bubbleExample(x []int, n int) {
	var j int = 0
	// elements x[0] .. x[j] are sorted
	//@ inv (forall k integer !(1 <= k && k <= j) || x[k - 1] <= x[k])
	for j < n-1 {
		var i int = 0
		// elements x[i + j] .. x[n]
		//@ inv (forall k integer !(n-1-i <= k && k <= n-1) || x[n-1-i] <= x[k])
		for i < n-j-1 {
			if x[i] > x[i+1] {
				var t int = x[i]
				x[i] = x[i+1]
				x[i+1] = t
			}
			i++
		}
		j++
	}
	return
}
