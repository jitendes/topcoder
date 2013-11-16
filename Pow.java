	public double powRecursive(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			x = 1 / x;
			n = -n; // need to /2 right away because Integer.min*-1 will
					// overflow
		}
		double tmp = powRecursive(x, n / 2);
		return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
	}

	public double powIterative(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		double product = 1;
		while (n > 0) {
			if (n % 2 == 1)
				product *= x; // when items are odd, multiply each level's
								// remainder
			x *= x; // each time power of 2
			n >>= 1;
		}
		return product;
	}
