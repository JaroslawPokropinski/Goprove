(
	((forall int p is (!(((1) <= (int p)) && ((int p) < ((int j) - (1))))) || 
	(((if ((int p) - (1)) == ((int j) - (1)) then []int x[int j] else (if ((int p) - (1)) == (int j) then []int x[(int j) - (1)] else []int x[(int p) - (1)]))) <= ((if (int p) == ((int j) - (1)) then []int x[int j] else (if (int p) == (int j) then []int x[(int j) - (1)] else []int x[int p]))))
	)) 
	&& 
	((forall int q is (!((((int j) - (1)) < (int q)) && ((int q) < ((int i) + (1))))) || 
	(((if ((int q) - (1)) == ((int j) - (1)) then []int x[int j] else (if ((int q) - (1)) == (int j) then []int x[(int j) - (1)] else []int x[(int q) - (1)]))) <= ((if (int q) == ((int j) - (1)) then []int x[int j] else (if (int q) == (int j) then []int x[(int j) - (1)] else []int x[int q]))))
	))
) && (((int j) - (1)) <= (int i))
