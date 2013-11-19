	public static boolean isNumber(String str) {
		if (str.length() == 0)
			return false;
		str.trim();
		// move to the first non-white char, if reaches to end, all are white
		boolean hasSign = false;
		boolean hasDec = false;
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur == '-' || cur == '+') {
				if (hasSign == false && i != str.length() - 1) {
					hasSign = true;
				} else {
					return false;
				}
			} else if (cur == '.') {
				if (hasDec == false && i != str.length() - 1) {
					hasDec = true;
				} else {
					return false;
				}
			} else if (cur < '0' || cur > '9') {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumberRegex(String s) {
		return s.matches("[+-]?\\d+(\\.)?\\d+");
	}
