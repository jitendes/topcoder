public static void printUnion(int[] arr1, int[] arr2) { 
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				System.out.printf(" %d ", arr1[i++]);
			} else if (arr2[j] < arr1[i]) {
				System.out.printf(" %d ", arr2[j++]);
			} else { /* if arr1[i] == arr2[j] */
				System.out.printf(" %d ", arr1[i++]);
				j++;
			}
		}
		while (i < arr1.length){
			System.out.printf(" %d ", arr1[i++]);
		}
		while (j < arr2.length){
			System.out.printf(" %d ", arr2[j++]);
		}
} 

public static void printIntersection(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr1[i]) {
				j++;
			} else { /* if arr1[i] == arr2[j] */
				System.out.printf(" %d ", arr2[j]);
				j++;
				i++;
			}
		}
}
