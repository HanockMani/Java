class SecondSmallestElement {
	public static void main(String[] args) {
		int[] array = { 5, 2, 8, 1, 9, 4, 3 };
		System.out.print("Array is: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		int secondSmallest = findSecondSmallest(array);
		System.out.println("\nThe second smallest element in the array is: " + secondSmallest);
	}
	
	public static int findSecondSmallest(int[] array) {
		if (array.length < 2) {
			System.out.println("Array size should be at least 2.");
			return -1; 
		}

		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
	
		for (int i = 0; i < array.length; i++) {
			if (array[i] < smallest) {
				secondSmallest = smallest;
				smallest = array[i];
			}
		 	else if (array[i] < secondSmallest && array[i] != smallest) {
				secondSmallest = array[i];
			}
		}
		return secondSmallest;
	}
}
